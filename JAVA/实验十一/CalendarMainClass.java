import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CalendarMainClass{
	public static void main(String args[]) {
		CalendarFrame frame = new CalendarFrame();
		frame.setTitle("日历应用程序");
		frame.setBounds(100, 100, 360, 300);
		frame.setVisible(true);
		frame.validate();
	}
}

class CalendarBean {
	String day[];
	int year = 2013, month = 0;
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	//返回某年某月1号开始的日期数组
	public String[] getCalendar() {
		String a[] = new String[42];
		Calendar 日历 = Calendar.getInstance();
		//注意：1月份是从0开始，所以要减1
		日历.set(year, month - 1, 1);
		int 星期几 = 日历.get(Calendar.DAY_OF_WEEK) - 1;
		int day = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = 30;
		}
		if (month == 2) {
			if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
				day = 29;
			} else {
				day = 28;
			}
		}
		for (int i = 星期几, n = 1; i < 星期几 + day; i++) {
			a[i] = String.valueOf(n);
			n++;
		}
		return a;
	}
}

class CalendarFrame extends Frame {
	Label labelDay[] = new Label[42];
	Label labelYear;
	Button titleName[] = new Button[7];
	Button nextMonth, previousMonth;
	Label showMessage;
	TextField inputYear;
	CalendarBean calendar;
	String name[] = { "日", "一", "二", "三", "四", "五", "六" };
	int year = 2013, month = 1;
	String days[];
	Panel pNorth;
	Panel pSouth;

	public CalendarFrame() {
		calendar = new CalendarBean();
		calendar.setYear(year);
		calendar.setMonth(month);
		days = calendar.getCalendar();

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(getCenterPanel());
		pNorth = this.getNorthPanel();
		pSouth = this.getSouthPanel();
		this.add(scrollPane, BorderLayout.CENTER);// 窗口添加scrollPane在中心区域
		this.add(pSouth, BorderLayout.SOUTH);// 窗口添加pNorth 在北面区域
		this.add(pNorth, BorderLayout.NORTH);// 窗口添加pSouth 在南区域。
	}

	private Panel getNorthPanel() {
		Panel panel = new Panel();

		this.labelYear = new Label("请输入年份:");
		this.nextMonth = new Button("下月");
		this.previousMonth = new Button("上月");
		this.inputYear = new TextField(7);

		panel.add((Component)labelYear);
		panel.add((Component)inputYear);
		panel.add((Component)previousMonth);
		panel.add((Component)nextMonth);

		return panel;
	}
	private Panel getCenterPanel() {
		Panel panel = new Panel();
        // 将panel的布局设置为7行7列的GridLayout布局
        panel.setLayout(new GridLayout(7, 7));
		for (int i = 0; i < 7; i++) {
			titleName[i] = new Button(name[i]);
			panel.add(titleName[i]);// panel添加组件titleName[i]。
		}
		for (int i = 0; i < 42; i++) {
			labelDay[i] = new Label("", Label.CENTER);
			panel.add(labelDay[i]);// panel添加组件labelDay[i]。
		}
		for (int i = 0; i < 42; i++) {
			labelDay[i].setText(days[i]);
		}
		
		return panel;
	}
	private Panel getSouthPanel() {
		Panel panel = new Panel();

        this.showMessage = new Label("日历" + year + "年" + month + "月");
        panel.add(showMessage);

		return panel;
	}
}