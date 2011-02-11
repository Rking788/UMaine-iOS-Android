package org.umece.android.umcampusmap;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import org.umece.android.umcampusmap.ParkingItemizedOverlay;
import org.umece.android.umcampusmap.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class UMCampusMap extends MapActivity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /* Get a reference to the MapView from the main layout 
         * also set built in zoom controls to true 
         */
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(true);
        
        /* Get the current MapController to set the center point to Barrows Hall */
        MapController mc = mapView.getController();
        
        /* Set the center and zoom on Barrows Hall */
        GeoPoint p1 = new GeoPoint(44902222, -68667222);
        mc.setCenter(p1);
        mc.setZoom(18);
          
        drawResidentOverlays();
    }

    public void drawStaffOverlays(){
    	MapView mapView = (MapView) findViewById(R.id.mapview);
    	/* In the ParkingItemizedOverlay class we should check if the list is empty before clearing */
    	List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.staffmarker);
        ParkingItemizedOverlay itemizedoverlay = new ParkingItemizedOverlay(drawable, this);	
        
        /* Create all OverlayItems */
        OverlayItem oi; 
        //oi = new OverlayItem(p1, "Hola, Mundo!", "I'm in Barrows Hall!");
        
    }
    
    public void drawResidentOverlays(){
    	MapView mapView = (MapView) findViewById(R.id.mapview);
    	List<Overlay> mapOverlays = mapView.getOverlays();
    	
    	/* Clear previous overlays */
    	mapOverlays.clear();
        Drawable drawable = this.getResources().getDrawable(R.drawable.residentmarker);
        ParkingItemizedOverlay itemizedoverlay = new ParkingItemizedOverlay(drawable, this);
    
        /* Create all OverlayItems */
        OverlayItem oi; 
        oi = new OverlayItem(new GeoPoint(44902571, -68673820), "College Ave Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44902546, -68672612), "Beta Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44903020, -68672652), "Next to Beta Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900358, -68673411), "Steam Plant", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44897846, -68672905), "Stodder Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44897353, -68670496), "Next to Carnegie", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44897159, -68669323), "Next to Merrill", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44896114, -68670192), "Behind Estabrooke", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44895790, -68668831), "Near Estabrooke", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44894546, -68668553), "Aroostook Lots", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44893645, -68669430), "Lengyl Field Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44901600, -68664345), "AEWC Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44903706, -68666187), "Gannett Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44903364, -68665532), "Cumberland Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44903698, -68665104), "Androscogin Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44903600, -68664112), "Knox Hall", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44904564, -68660993), "Hilltop Lot", "");
        itemizedoverlay.addOverlay(oi);
        
        mapOverlays.add(itemizedoverlay);
    }
    
    public void drawCommuterOverlays(){
    	MapView mapView = (MapView) findViewById(R.id.mapview);
    	List<Overlay> mapOverlays = mapView.getOverlays();
    	
    	/* Clear previous overlays */
    	mapOverlays.clear();
        Drawable drawable = this.getResources().getDrawable(R.drawable.commutermarker);
        ParkingItemizedOverlay itemizedoverlay = new ParkingItemizedOverlay(drawable, this);
    
        /* Create all OverlayItems */
        OverlayItem oi;
        oi = new OverlayItem(new GeoPoint(44905600, -68673180), "Satellite Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44904604, -68672796), "Alfond Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44904043, -68671536), "Football Field Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900204, -68673878), "Steam Plant Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44896433, -68671891), "Chadbourne Hall Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44894484, -68667980), "Sawyer Environmental Research Center", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44895433, -68666380), "near Libby Hall", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44897032, -68665872), "near Nutting Hall", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44898900, -68664591), "Sebago Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900165, -68663975), "CCA Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44905288, -68662770), "Rec Center Lot", "");
        itemizedoverlay.addOverlay(oi);
        
        /* Add all overlays to the mapview */
        mapOverlays.add(itemizedoverlay);
    }
    
    public void drawVisitorOverlays(){
    	MapView mapView = (MapView) findViewById(R.id.mapview);
    	List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.commutermarker);
        ParkingItemizedOverlay itemizedoverlay = new ParkingItemizedOverlay(drawable, this);
    	
        /* Create all OverlayItems */
        OverlayItem oi;
        oi = new OverlayItem(new GeoPoint(44903164, -68672766), "Crossland Hall Lot", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900533, -68671210), "West of Lord Hall", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900485, -68670366), "South of Lord Hall", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44897564, -68666540), "near Small Animal Research", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44898544, -68666879), "near Maine Bound", "");
        itemizedoverlay.addOverlay(oi);
        oi = new OverlayItem(new GeoPoint(44900492, -68667990), "near Union", "");
        itemizedoverlay.addOverlay(oi);
        
        /* Add all overlays to the mapview */
        mapOverlays.add(itemizedoverlay);
    }
    
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}