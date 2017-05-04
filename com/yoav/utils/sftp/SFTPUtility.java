package com.yoav.utils.sftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPUtility {
	private static final String SFTP = "sftp";
	private static final Logger log = LoggerFactory.getLogger(SFTPUtility.class);

	public static void sendViaSFTP(SFTPUtilityInput input) throws SFTPFailureException  {
		int SFTPPORT = 22;
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		log.debug("SFTPUtility - preparing the host information for sftp.");
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(input.getUser(), input.getHostOrIP(), SFTPPORT);
			session.setPassword(input.getPassword());
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			log.debug("SFTPUtility - Host connected.");
			channel = session.openChannel(SFTP);
			channel.connect();
			log.debug("SFTPUtility - sftp channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(input.getDirectory());
			channelSftp.put(input.getFileToSend(), input.getFileName());
			log.debug("SFTPUtility - File transfered successfully to host. file name: " + input.getFileName());
		} catch (JSchException | SftpException ex) {
			log.error("SFTPUtility - General exception occured while transfering. " + ex);
			throw new SFTPFailureException(ex);
		} finally {
			channelSftp.exit();
			channel.disconnect();
			session.disconnect();
		}
	}
}
