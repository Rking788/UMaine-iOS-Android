//
//  iUMaineAppDelegate.h
//  iUMaine
//
//  Created by RKing on 4/17/11.
//  Copyright 2011 UMaineIRL?. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@class SportEvent;
@class ScheduleViewController;
@class SportsViewController;
@class MapViewController;
@class CampusSpecifics;

@interface iUMaineAppDelegate : NSObject <UIApplicationDelegate, UITabBarControllerDelegate> {

    NSManagedObjectContext *_managedObjectContext;
    NSManagedObjectModel* _managedObjectModel;
    NSPersistentStoreCoordinator* _persistentStoreCoordinator;
    
    NSUserDefaults* defaultPrefs;
    CampusSpecifics* campusSpecifics;
    NSString* lastUpdateStr;
    
    ScheduleViewController* svcInst;
    SportsViewController* spvcInst;
    MapViewController* mvcInst;
    
    BOOL gettingSports;
}

@property (nonatomic, strong) IBOutlet UIWindow *window;

@property (nonatomic, strong) IBOutlet UITabBarController *tabBarController;
@property (strong, nonatomic) IBOutlet UIView *progressView;
@property (strong, nonatomic) IBOutlet UIProgressView *progressBar;
@property (strong, nonatomic) IBOutlet UILabel *progressText;

@property (strong, atomic) ScheduleViewController* svcInst;
@property (strong, atomic) SportsViewController* spvcInst;
@property (strong, atomic) MapViewController* mvcInst;

//@property (strong, nonatomic) NSString* selCampus;

// Core Data related properties
@property (nonatomic, strong, readonly) NSManagedObjectContext* managedObjectContext;
@property (nonatomic, strong, readonly) NSManagedObjectModel* managedObjectModel;
@property (nonatomic, strong, readonly) NSPersistentStoreCoordinator* persistentStoreCoordinator;

@property (nonatomic, strong) NSUserDefaults* defaultPrefs;
@property (nonatomic, strong) CampusSpecifics* campusSpecifics;
@property (nonatomic, strong) NSString* lastUpdateStr;
@property (atomic, assign, getter = isGettingSports) BOOL gettingSports;

- (NSString *)applicationDocumentsDirectory;
//- (void)saveContext;

- (void)loadDefaultDB;
+ (iUMaineAppDelegate*) sharedAppDelegate;
+ (NSString*) getSelCampus;
+ (void) setSelCampus: (NSString*) campus;

- (void) resetContext;
- (void) saveContext;

- (void) campusSelected: (NSString*) campusStr;

- (void) checkServer;
- (void) checkSportsUpdates;
- (void) updateOrAddEvent:(SportEvent *)newE WithMOC: (NSManagedObjectContext*) moc;
- (void) doneLoadingSports;

- (void) checkForNewSemesters;
- (NSArray*) getLocalSemestersWithMOC:(NSManagedObjectContext*) moc;
- (void) fetchSemesterCourses: (NSString*) semStr WithMOC: (NSManagedObjectContext*) moc;
- (void) reloadSVCSemesters;

- (void) addProgressBarView;
- (void) animateProgressViewIn: (NSNumber*) show;
- (void) updateProgressBar: (NSNumber*) percent;
- (void) updateProgressTitle: (NSString*) text;
+ (NSString*) semesterStrToReadable: (NSString*) semesterStr;

@end
