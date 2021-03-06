package org.umece.android.umaine.sports;

import java.util.Calendar;
/* import java.util.Date; */
import java.util.List;
import org.umece.android.umaine.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SportsDisplaySchAll extends Activity {

	SportsGrabData sgd = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.sprots_activity_sch_all);

		sgd = new SportsGrabData();
		
		Calendar ca =  Calendar.getInstance();
		/* Find Tablelayout defined in myTableLayout.xml */
		TableLayout tl = (TableLayout)findViewById(R.id.myTableLayout);

		/* Get information from the server */
		ProgressDialog dialog = ProgressDialog.show(this, "", "Loading sports information...", true);
		List<String> retval = sgd.postEventType("all");
		dialog.dismiss();

		int current = 0;
		boolean bPassedLast = true;
		
		/* Define a solid line to be drawn between the last event and next event */
		View solidBlueView = new View(this);
		solidBlueView.setBackgroundColor(R.color.maine_blue);
		
		for (String s : retval) {
			current++;

			String[] row = s.split(";");

			sgd.setPostDate(row[0]);
			sgd.setPostEvent(row[1]);
			sgd.setPostLocation(row[2]);
			sgd.setPostTime(row[3]);
			
			TableRow tr = new TableRow(this);
			
			/* *
			 * check the sgd.getPostDate() 
			 * if the schedule is coming, set the row the textColor Color.BLACK 
			 * if the schedule has done, set the row textColor as R.color.maine_lightblue
			 * 
			 */

			TextView labelDate = new TextView(this);
			TextView labelEvent = new TextView(this);
			TextView labelLocation = new TextView(this);
			TextView labelTime = new TextView(this);

			String[] dateSplit = null ;
			
			if (!sgd.getPostDate().contains("-")){
				dateSplit = sgd.getPostDate().split("/");
			}
			else {
				String str2 = sgd.getPostDate().substring(sgd.getPostDate().indexOf("-")+1);
				dateSplit = str2.split("/");
			}
			
			int tempMonth = Integer.parseInt(dateSplit[0]);
			int tempDay = Integer.parseInt(dateSplit[1]);
			int tempYear = (Integer.parseInt(dateSplit[2]) + 2000);

			boolean bPassed = false;
			// The month is +1 because it is zero based and the database is not
			int curMonth = ca.get(Calendar.MONTH) + 1;
			int curDate = ca.get(Calendar.DATE);
			int curYear = ca.get(Calendar.YEAR);
			
			if(tempYear < curYear)
				bPassed = true;
			else if((tempYear == curYear) && (tempMonth < curMonth))
				bPassed = true;
			else if((tempYear == curYear) && (tempMonth == curMonth) && (tempDay < curDate))
				bPassed = true;
			
			if (bPassed){
				/*labelDate.setTextColor(R.color.maine_lightblue);
				labelEvent.setTextColor(R.color.maine_lightblue);
				labelLocation.setTextColor(R.color.maine_lightblue);
				labelTime.setTextColor(R.color.maine_lightblue);*/
				
				labelDate.setTextColor(Color.GRAY);
				labelEvent.setTextColor(Color.GRAY);
				labelLocation.setTextColor(Color.GRAY);
				labelTime.setTextColor(Color.GRAY);
			}
			else{
				labelDate.setTextColor(Color.BLACK);
				labelEvent.setTextColor(Color.BLACK);
				labelLocation.setTextColor(Color.BLACK);
				labelTime.setTextColor(Color.BLACK);
			}
			
			
			

			// Create a TextView to house the name of the province
			
			labelDate.setId(100 + current);
			labelDate.setText(sgd.getPostDate());
			labelDate.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelDate.setGravity(android.view.Gravity.LEFT);
			labelDate.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the value of the after-tax income
			
			labelEvent.setId(200 + current);
			labelEvent.setText(sgd.getPostEvent());
			labelEvent.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelEvent.setGravity(android.view.Gravity.LEFT);
			labelEvent.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the name of the province
			
			labelLocation.setId(300 + current);
			labelLocation.setText(sgd.getPostLocation());
			labelLocation.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelLocation.setGravity(android.view.Gravity.LEFT);
			labelLocation.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the value of the after-tax income
			labelTime.setId(400 + current);
			labelTime.setText(sgd.getPostTime());
			labelTime.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelTime.setGravity(android.view.Gravity.LEFT);
			labelTime.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		

			// set the table
			tr.setId(current);
			tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.FILL_PARENT));
			tr.addView(labelDate);
			tr.addView(labelEvent);
			tr.addView(labelLocation);
			tr.addView(labelTime);
			
			// Draw the solid line if needed 
			if((!bPassed) && (bPassedLast))
				tl.addView(solidBlueView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 2));
			
			// Add the TableRow to the TableLayout
			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			
			bPassedLast = bPassed;
		}
	}

}
