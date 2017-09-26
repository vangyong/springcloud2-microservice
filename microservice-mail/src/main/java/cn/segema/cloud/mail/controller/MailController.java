package cn.segema.cloud.mail.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.segema.cloud.mail.service.EmailService;
import cn.segema.cloud.mail.test.domain.ActivitiUser;
import cn.segema.cloud.mail.test.repository.ActivitiUserRepository;

@Controller
@RequestMapping(value = "/mail")
public class MailController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private ActivitiUserRepository activitiUserRepository;

	@Autowired
	private EmailService emailService;

	/**
	 * @param id
	 * @return user信息
	 */
	@RequestMapping("/{userId}")
	@ResponseBody
	public ActivitiUser findById(@PathVariable Integer userId) {
		ActivitiUser findOne = this.activitiUserRepository.findOne(userId);
		return findOne;
	}

	@RequestMapping("/listUI")
	public ModelAndView listUI(ActivitiUser user, Model model) {
		ModelAndView ModelAndView = new ModelAndView("/test/activiti/user/listUI");
		return ModelAndView;
	}

	/**
	 * 测试邮件发送
	 */
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	@ResponseBody
	public String sendEmail() throws Exception {
		// String sendTo = "1265400024@qq.com";
		// String titel = "测试邮件标题";
		// String content = "测试邮件内容";
		// emailService.sendSimpleMail(sendTo, titel, content);

		// String host = "192.168.1.98"; // 指定的smtp服务器，本机的局域网IP
		String host = "192.168.11.200"; // 本机smtp服务器
		String from = "acl1@aclyyx.com"; // 邮件发送人的邮件地址
		String to = "acl2@aclyyx.com"; // 邮件接收人的邮件地址
		final String username = "acl1"; // 发件人的邮件帐户
		final String password = "111111"; // 发件人的邮件密码

		// 创建Properties 对象
		Properties props = System.getProperties();

		// 添加smtp服务器属性
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "26");
		props.put("mail.smtp.auth", "true");

		// 创建邮件会话
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// 定义邮件信息
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(transferChinese("我有自己的邮件服务器了"));

			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent("rt,我有自己的邮件服务器了", "text/html;charset=gb2312");
			mp.addBodyPart(mbp);

			// 添加附件
			// mbp=new MimeBodyPart();
			// String filename= "G:\\hi.txt"; //选择出每一个附件名
			// FileDataSource fds = new FileDataSource(filename); //得到数据源
			// mbp.setDataHandler(new DataHandler(fds)); //得到附件本身并至入BodyPart
			// mbp.setFileName(fds.getName()); //得到文件名同样至入BodyPart
			// mp.addBodyPart(mbp);

			message.setContent(mp);

			// 发送消息
			session.getTransport("smtp").send(message);
			// Transport.send(message); //也可以这样创建Transport对象发送
			System.out.println("SendMail Process Over!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 测试邮件发送
	 */
	@RequestMapping(value = "/receiveEmail", method = RequestMethod.GET)
	@ResponseBody
	public String receiveEmail() {
		String host = "192.168.11.200";
		final String username = "acl2";
		final String password = "111111";

		// 创建Properties 对象
		Properties props = new Properties();

		// 创建邮件会话
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}

		});

		try {
			// 获取邮箱的pop3存储
			Store store = session.getStore("pop3");
			store.connect(host, username, password);

			// 获取inbox文件
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY); // 打开，打开后才能读取邮件信息

			// 获取邮件消息
			Message message[] = folder.getMessages();

			for (int i = 0, n = message.length; i < n; i++) {
				System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
				try {
					message[i].writeTo(System.out);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			// 关闭资源
			folder.close(false);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("GetMail Process Over!");
		return null;
	}

	// 邮件主题中文字符转换
	private String transferChinese(String strText) {
		try {
			strText = MimeUtility.encodeText(new String(strText.getBytes(), "GB2312"), "GB2312", "B");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strText;
	}

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@RequestMapping("/instance-info")
	@ResponseBody
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
