package ds.dk.yuoto.libutils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * 时间转换，几小时前等等...
	 * @param createDate long类型的时间
	 * @return
     */
	public static String getTime(long createDate) {
		long millis = System.currentTimeMillis();

		SimpleDateFormat format0 = new SimpleDateFormat("yyyy");
		SimpleDateFormat format1 = new SimpleDateFormat("MM");
		SimpleDateFormat format2 = new SimpleDateFormat("dd");
		SimpleDateFormat format3 = new SimpleDateFormat("HH");
		SimpleDateFormat otherFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = otherFormat.format(new Date(createDate));

		int newYY = Integer.parseInt(format0.format(new Date(millis)));
		int reYY = Integer.parseInt(format0.format(new Date(createDate)));

		int newMM = Integer.parseInt(format1.format(new Date(millis)));
		int reMM = Integer.parseInt(format1.format(new Date(createDate)));

		int newDD = Integer.parseInt(format2.format(new Date(millis)));
		int reDD = Integer.parseInt(format2.format(new Date(createDate)));

		int newHH = Integer.parseInt(format3.format(new Date(millis)));
		int reHH = Integer.parseInt(format3.format(new Date(createDate)));

		if ((newYY - reYY) == 0) {
			if ((newMM - reMM) == 0) {
				if ((newDD - reDD) == 0) {
					int HH = newHH - reHH;
					if (HH == 0) {
						return "刚刚";
					} else {
						return HH + "小时前";
					}
				} else if ((newDD - reDD) == 1) {
					return "昨天";
				} else if ((newDD - reDD) == 2) {
					return "前天";
				} else {
					return time;
				}
			} else {
				return time;
			}
		} else {
			return time;
		}
	}

	/**
	 * 根据格式返回时间字符串
	 * @param createDate
	 * @param format
	 * @return
	 */
	public static String getTimeByFormat(long createDate, String format) {
		SimpleDateFormat otherFormat = new SimpleDateFormat(format);
		String time = otherFormat.format(new Date(createDate));
		return time;
	}
}
