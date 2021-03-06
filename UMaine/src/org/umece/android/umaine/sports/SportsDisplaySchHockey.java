package org.umece.android.umaine.sports;

import java.util.Calendar;
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

public class SportsDisplaySchHockey extends Activity {

	SportsGrabData sgdho = null;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.sprots_activity_sch_hockey);
		sgdho = new SportsGrabData();
		
		Calendar ca =  Calendar.getInstance();
		/* Find Tablelayout defined in myTableLayout.xml */
		TableLayout tl = (TableLayout) findViewById(R.id.hoTableLayout);

		/* Get information from the server */
		ProgressDialog dialog = ProgressDialog.show(this, "", "Loading sports information...", true);
		List<String>retvalho = sgdho.postEventType("hockey");
		dialog.dismiss();
		
		int current = 0;
		
		boolean bPassedLast = true;
		
		/* Define a solid line to be drawn between the last event and next event */
		View solidBlueView = new View(this);
		solidBlueView.setBackgroundColor(R.color.maine_blue);
		
		for (String s : retvalho) {
			current++;
			
			String [] row = s.split(";");

			sgdho.setPostDate(row[0]);
			sgdho.setPostEvent(row[1]);
			sgdho.setPostLocation(row[2]);
			sgdho.setPostTime(row[3]);

			TableRow tr = new TableRow(this);
			TextView labelDate = new TextView(this);
			TextView labelEvent = new TextView(this);
			TextView labelLocation = new TextView(this);
			TextView labelTime = new TextView(this);

			String[] dateSplit = null ;
			
			if (!sgdho.getPostDate().contains("-")){
				dateSplit = sgdho.getPostDate().split("/");
			}
			else {
				String str2 = sgdho.getPostDate().substring(sgdho.getPostDate().indexOf("-")+1);
				dateSplit = str2.split("/");
			}
			
			int tempMonth = Integer.parseInt(dateSplit[0]);
			int tempDay = Integer.parseInt(dateSplit[1]);
			int tempYear = Integer.parseInt(dateSplit[2]) + 2000;

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
				labelDate.setTextColor(R.color.maine_lightblue);
				labelEvent.setTextColor(R.color.maine_lightblue);
				labelLocation.setTextColor(R.color.maine_lightblue);
				labelTime.setTextColor(R.color.maine_lightblue);
				
			}
			else{
				labelDate.setTextColor(Color.BLACK);
				labelEvent.setTextColor(Color.BLACK);
				labelLocation.setTextColor(Color.BLACK);
				labelTime.setTextColor(Color.BLACK);
			}
			
			
			

			// Create a TextView to house the name of the province
			
			labelDate.setId(100 + current);
			labelDate.setText(sgdho.getPostDate());
			labelDate.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelDate.setGravity(android.view.Gravity.LEFT);
			labelDate.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the value of the after-tax income
			
			labelEvent.setId(200 + current);
			labelEvent.setText(sgdho.getPostEvent());
			labelEvent.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelEvent.setGravity(android.view.Gravity.LEFT);
			labelEvent.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the name of the province
			
			labelLocation.setId(300 + current);
			labelLocation.setText(sgdho.getPostLocation());
			labelLocation.setTextSize(TypedValue.COMPLEX_UNIT_SP,
					UMSports.TEXT_SIZE);
			labelLocation.setGravity(android.view.Gravity.LEFT);
			labelLocation.setLayoutParams(new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			

			// Create a TextView to house the value of the after-tax income
			labelTime.setId(400 + current);
			labelTime.setText(sgdho.getPostTime());
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
