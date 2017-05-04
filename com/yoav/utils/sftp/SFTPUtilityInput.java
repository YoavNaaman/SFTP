package com.yoav.utils.sftp;

import java.io.ByteArrayInputStream;

import com.yoav.utils.sftp.ValidatorException;

public class SFTPUtilityInput {
	private String hostOrIP;
	private String user;
	private String password;
	private String directory;
	private ByteArrayInputStream fileToSend;
	private String fileName;

	public SFTPUtilityInput(String hostorIP, String user, String password, String directory,
			ByteArrayInputStream fileToSend, String fileName) throws ValidatorException{
		super();
		if(null == hostorIP || (null != hostorIP && hostorIP.isEmpty())){
			throw new ValidatorException("SFTPUtilityInput - hostorIP is null or empty");
		}
		if(null == user || (null != user && user.isEmpty())){
			throw new ValidatorException("SFTPUtilityInput - user is null or empty");
		}
		if(null == password || (null != password && password.isEmpty())){
			throw new ValidatorException("SFTPUtilityInput - password is null or empty");
		}
		if(null == directory || (null != directory && directory.isEmpty())){
			throw new ValidatorException("SFTPUtilityInput - directory is null or empty");
		}
		if(null == fileToSend){
			throw new ValidatorException("SFTPUtilityInput - fileToSend is null");
		}
		if(null == fileName || (null != fileName && fileName.isEmpty())){
			throw new ValidatorException("SFTPUtilityInput - fileName is null or empty");
		}
		this.hostOrIP = hostorIP;
		this.user = user;
		this.password = password;
		this.directory = directory;
		this.fileToSend = fileToSend;
		this.fileName = fileName;
	}

	public String getHostOrIP() {
		return hostOrIP;
	}

	public void setHostOrIP(String hostOrIP) {
		this.hostOrIP = hostOrIP;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public ByteArrayInputStream getFileToSend() {
		return fileToSend;
	}

	public void setFileToSend(ByteArrayInputStream fileToSend) {
		this.fileToSend = fileToSend;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
