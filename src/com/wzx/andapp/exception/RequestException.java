package com.wzx.andapp.exception;

public class RequestException extends BaseException {
	private static final long serialVersionUID = 1L;
	/**
	 * {@link EOFException} �׳������쳣����ʾ���Ӷ�ʧ��Ҳ����˵�������ӵ���һ�˷������ر����ӣ������������ϵ硢���߳��ֹ��ϵȵ��£�
	 */
	public final static int SERVER_CLOSED_EXCEPTION = 0x01;

	/**
	 * {@link SocketException} �׳������쳣����ʾ�޷����ӣ�Ҳ����˵��ǰ����������
	 */
	public final static int CONNECT_EXCEPTION = 0X02;

	/**
	 * {@link SocketException} �׳������쳣����ʾ
	 * <ul>
	 * <li>1�����������رգ�Ҳ����˵��һ�������ر�����</li>
	 * <li>2����ʾһ�˹ر����ӣ�����һ�˴�ʱ�ڶ�����</li>
	 * <li>3����ʾһ�˹ر����ӣ�����һ�˴�ʱ�ڷ�������</li>
	 * <li>4����ʾ�����ѹرգ���������ʹ�ã�Ҳ���Ƕ�/д������������</li>
	 * </ul>
	 */
	public final static int SOCKET_EXCEPTION = 0x03;

	/**
	 * {@link BindException} �׳������쳣����ʾ�˿��Ѿ���ռ��
	 */
	public final static int BIND_EXCEPTION = 0x04;

	/**
	 * {@link ConnectTimeoutException} ���ӳ�ʱ
	 */
	public final static int CONNECT_TIMEOUT_EXCEPTION = 0x05;

	/**
	 * {@link UnsupportedEncodingException} ��֧�ֵı����쳣
	 */
	public final static int UNSUPPORTED_ENCODEING_EXCEPTION = 0x06;

	/**
	 * {@link SocketTimeoutException} socket ��ʱ�쳣
	 */
	public final static int SOCKET_TIMEOUT_EXCEPTION = 0x06;

	/**
	 * {@link ClientProtocolException} �ͻ���Э���쳣
	 */
	public final static int CLIENT_PROTOL_EXCEPTION = 0x07;

	/**
	 * {@link IOException} ��ȡ�쳣
	 */
	public final static int IO_EXCEPTION = 0x08;

	public RequestException(int code, String msg, Throwable throwable) {
		super(code, msg, throwable);
		// TODO Auto-generated constructor stub
	}

	public RequestException(int code, Throwable throwable) {
		super(code, throwable);
		// TODO Auto-generated constructor stub
	}

	public RequestException(int code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public RequestException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}
}