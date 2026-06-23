/*    */ package view.keyboard;public class KeyPageMain extends KeyPage { public final Key ASSIGN_HOTKEY; public final Key SCROLL_LEFT; public final Key SCROLL_RIGHT; public final Key SCROLL_UP; public final Key SCROLL_DOWN; public final Key ZOOM_IN; public final Key ZOOM_OUT; public final Key MINIMAP; public final Key THRONE; public final Key ROTATE;
/*    */   public final Key GROW;
/*    */   public final Key SHRINK;
/*    */   public final Key QUICKSAVE;
/*    */   public final Key QUICKLOAD;
/*    */   public final Key PAUSE;
/*    */   
/*    */   KeyPageMain() {
/*  9 */     super("MAIN");
/*    */ 
/*    */ 
/*    */     
/* 13 */     D.gInit(this);
/*    */ 
/*    */     
/* 16 */     this.ASSIGN_HOTKEY = new Key("ASSIGN_HOTKEY", D.g("Assign-hotkey"), D.g("AssignD", "When hovering specific buttons, you can press this to assign a new hotkey for the button function."), this, 341, 72);
/* 17 */     this.SCROLL_LEFT = new Key("SCROLL_LEFT", D.g("Scroll-Left"), D.g("Scroll-LeftD", "Moves the map."), this, 65);
/* 18 */     this.SCROLL_RIGHT = new Key("SCROLL_RIGHT", D.g("Scroll-Right"), D.g("Scroll-RightD", "Moves the map."), this, 68);
/* 19 */     this.SCROLL_UP = new Key("SCROLL_UP", D.g("Scroll-Up"), D.g("Scroll-UpD", "Moves the map."), this, 87);
/* 20 */     this.SCROLL_DOWN = new Key("SCROLL_DOWN", D.g("Scroll-Down"), D.g("Scroll-DownD", "Moves the map."), this, 83);
/* 21 */     this.ZOOM_IN = new Key("ZOOM_IN", D.g("Zoom-In"), D.g("Zoom-InD", "Zoom in (Mousewheel)."), this, 78);
/* 22 */     this.ZOOM_OUT = new Key("ZOOM_OUT", D.g("Zoom-Out"), D.g("Zoom-OutD", "Zoom out (Mousewheel)."), this, 66);
/* 23 */     this.MINIMAP = new Key("MINIthis", D.g("Minimap"), D.g("MinimapD", "Toggles the minimap."), this, 77);
/* 24 */     this.THRONE = new Key("THRONE", D.g("Center"), D.g("ThroneD", "Center the map on the throne or the capital."), this, 341, 65);
/*    */     
/* 26 */     this.ROTATE = new Key("ROTATE", D.g("Rotate"), D.g("RotateD", "Rotates things."), this, 82);
/* 27 */     this.GROW = new Key("GROW", D.g("Increase"), D.g("IncreaseD", "Increases size/cycle options."), this, 69);
/* 28 */     this.SHRINK = new Key("SHRINK", D.g("Decrease"), D.g("DecreaseD", "Increases size/cycle options."), this, 81);
/*    */     
/* 30 */     this.QUICKSAVE = new Key("QUICKSAVE", D.g("Quicksave"), D.g("QuicksaveD", "Saves the game under the name 'Quicksave'."), this, 341, 83);
/* 31 */     this.QUICKLOAD = new Key("QUICKLOAD", D.g("Quick-Load"), D.g("QuickLoadD", "Loads the latest save."), this);
/* 32 */     this.PAUSE = new Key("PAUSE", D.g("Pause"), D.g("PauseD", "Toggles game pause."), this, 49);
/*    */     
/* 34 */     this.SPEED1 = new Key("SPEED1", D.g("speed-normal"), D.g("speed-normalD", "Sets 1x speed. Double press for 1/4th speed."), this, 50);
/* 35 */     this.SPEED2 = new Key("SPEED2", D.g("speed-fast"), D.g("speed-fastD", "Sets 5x speed."), this, 51);
/* 36 */     this.SPEED3 = new Key("SPEED3", D.g("speed-fastest"), D.g("speed-fastestD", "Sets 25x speed. Double press for x250 speed."), this, 52);
/*    */     
/* 38 */     this.MUP = new Key("MAP_UP", D.g("Slow-Up"), D.g("Slow-UpD", "Slowly pans the map."), this, 342, 265);
/* 39 */     this.MDOWN = new Key("MAP_DOWN", D.g("Slow-Down"), D.g("Slow-DownD", "Slowly pans the map."), this, 342, 264);
/* 40 */     this.MLEFT = new Key("MAP_LEFT", D.g("Slow-Left"), D.g("Slow-LeftD", "Slowly pans the map."), this, 342, 263);
/* 41 */     this.MRIGHT = new Key("MAP_RIGHT", D.g("Slow-Right"), D.g("Slow-RightD", "Slowly pans the map-"), this, 342, 262);
/*    */     
/* 43 */     this.SCREENSHOT = new Key("SCREENSHOT", D.g("Screenshot"), D.g("ScreenshotD", "Creates a screenshot, saved in your local files, reachable through the launcher -> info."), this, -1, 283, false);
/*    */     
/* 45 */     this.DEBUGGER = new Key("STATS", D.g("Stats"), D.g("StatsD", "Toggles stats."), this, 300);
/*    */     
/* 47 */     this.ENTER = new Key("ENTER", D.g("Enter"), D.g("EnterD", "The enter key."), this, -1, 257, false);
/* 48 */     this.BACKSPACE = new Key("BACKSPACE", D.g("Backspace"), D.g("BackspaceD", "The backspace key."), this, -1, 259, false);
/* 49 */     this.ESCAPE = new Key("ESCAPE", D.g("Escape"), D.g("EscapeD", "Toggles the menu, or closes panels."), this, -1, 256, false);
/*    */     
/* 51 */     this.MOD = new Key("MOD", D.g("mod"), D.g("modD", "When pressed, modulates certain functions, such as the mouse wheel."), this, 341);
/* 52 */     this.UNDO = new Key("UNDO", D.g("place-undo"), D.g("place-undoD", "When pressed, lets you use alternative tools when using a tool."), this, 340);
/*    */     
/* 54 */     this.SWAP = new Key("SWAP", D.g("toggle", "Toggle view"), D.g("toggleD", "Toggle between common views."), this, 258);
/*    */     
/* 56 */     this.name = D.g("General");
/*    */   }
/*    */   public final Key SPEED1; public final Key SPEED2; public final Key SPEED3; public final Key MUP; public final Key MDOWN; public final Key MLEFT; public final Key MRIGHT; public final Key SCREENSHOT; public final Key DEBUGGER; public final Key ENTER; public final Key BACKSPACE; public final Key ESCAPE; public final Key MOD; public final Key UNDO; public final Key SWAP; private final CharSequence name;
/*    */   public CharSequence name() {
/* 60 */     return this.name;
/*    */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyPageMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */