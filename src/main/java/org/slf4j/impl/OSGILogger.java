package org.slf4j.impl;

import org.osgi.service.log.LogService;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/**
 * Logger that passes entries to current LogService Unavailability of service
 * will not log anything
 */
public class OSGILogger extends MarkerIgnoringBase {

	public OSGILogger() {
	}

	private void logToService(int level, Object message, Throwable t) {
		final LogService service = OSGILogFactory.currentLogService;

		if (service == null) {
			return;
		}

		try {
			if (t != null) {
				service.log(null, level, message.toString(), t);
			} else {
				service.log(null, level, message.toString());
			}
		} catch (Exception ex) {
		}
	}

	@Override
	public boolean isTraceEnabled() {
		return true;
	}

	@Override
	public void trace(String msg) {
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void trace(String format, Object arg) {
		String msg = MessageFormatter.format(format, arg).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		String msg = MessageFormatter.format(format, arg1, arg2).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void trace(String format, Object[] argArray) {
		String msg = MessageFormatter.arrayFormat(format, argArray).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void trace(String msg, Throwable t) {
		logToService(LogService.LOG_DEBUG, msg, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return true;
	}

	@Override
	public void debug(String msg) {
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void debug(String format, Object arg) {
		String msg = MessageFormatter.format(format, arg).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		String msg = MessageFormatter.format(format, arg1, arg2).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void debug(String format, Object[] argArray) {
		String msg = MessageFormatter.arrayFormat(format, argArray).getMessage();
		logToService(LogService.LOG_DEBUG, msg, null);
	}

	@Override
	public void debug(String msg, Throwable t) {
		logToService(LogService.LOG_DEBUG, msg, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public void info(String msg) {
		logToService(LogService.LOG_INFO, msg, null);
	}

	@Override
	public void info(String format, Object arg) {
		String msg = MessageFormatter.format(format, arg).getMessage();
		logToService(LogService.LOG_INFO, msg, null);
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		String msg = MessageFormatter.format(format, arg1, arg2).getMessage();
		logToService(LogService.LOG_INFO, msg, null);
	}

	@Override
	public void info(String format, Object[] argArray) {
		String msg = MessageFormatter.arrayFormat(format, argArray).getMessage();
		logToService(LogService.LOG_INFO, msg, null);
	}

	@Override
	public void info(String msg, Throwable t) {
		logToService(LogService.LOG_INFO, msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public void warn(String msg) {
		logToService(LogService.LOG_WARNING, msg, null);
	}

	@Override
	public void warn(String format, Object arg) {
		String msg = MessageFormatter.format(format, arg).getMessage();
		logToService(LogService.LOG_WARNING, msg, null);
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		String msg = MessageFormatter.format(format, arg1, arg2).getMessage();
		logToService(LogService.LOG_WARNING, msg, null);
	}

	@Override
	public void warn(String format, Object[] argArray) {
		String msg = MessageFormatter.arrayFormat(format, argArray).getMessage();
		logToService(LogService.LOG_WARNING, msg, null);
	}

	@Override
	public void warn(String msg, Throwable t) {
		logToService(LogService.LOG_WARNING, msg, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public void error(String msg) {
		logToService(LogService.LOG_ERROR, msg, null);
	}

	@Override
	public void error(String format, Object arg) {
		String msg = MessageFormatter.format(format, arg).getMessage();
		logToService(LogService.LOG_ERROR, msg, null);
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		String msg = MessageFormatter.format(format, arg1, arg2).getMessage();
		logToService(LogService.LOG_ERROR, msg, null);
	}

	@Override
	public void error(String format, Object[] argArray) {
		String msg = MessageFormatter.arrayFormat(format, argArray).getMessage();
		logToService(LogService.LOG_ERROR, msg, null);
	}

	@Override
	public void error(String msg, Throwable t) {
		logToService(LogService.LOG_ERROR, msg, t);
	}
}
