/*    */ package game.audio;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.gui.misc.GButt;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ 
/*    */ final class SoundRaces
/*    */ {
/*    */   private final RMAP<SoundRace> rmap;
/*    */   private boolean debugged = false;
/*    */   private final SoundRace RDUMMY;
/*    */   
/*    */   SoundRaces(SoundFactory factory) {
/* 20 */     LinkedList<SoundRace> all = new LinkedList();
/*    */     
/* 22 */     PATH p = (PATHS.AUDIO()).config.getFolder("mono"); byte b; int i; String[] arrayOfString;
/* 23 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String file = arrayOfString[b];
/* 24 */       Json json = new Json(p.gets(file));
/* 25 */       LIST<String> keys = json.keys();
/*    */       
/* 27 */       for (String k : keys) {
/* 28 */         all.add(new SoundRace(all.size(), k, factory.read(k, json)));
/*    */       }
/*    */       
/*    */       b++; }
/*    */     
/* 33 */     this.rmap = new RMAP("SOUND", (LIST)all);
/* 34 */     this.RDUMMY = new SoundRace(0, "DUMMY", new Sound(factory.factory.LDUMMY()));
/*    */     
/* 36 */     GButt.defaultHoverSound = get("UI_HOVER");
/* 37 */     GButt.defaultClickSound = get("UI_CLICK");
/*    */   }
/*    */   
/*    */   public SoundRace get(String key) {
/* 41 */     if (this.rmap.tryGet(key) == null) {
/*    */       
/* 43 */       if (!this.debugged) {
/* 44 */         String a = "Available " + System.lineSeparator();
/* 45 */         for (String s : this.rmap.available()) {
/* 46 */           a = a + a + s;
/*    */         }
/*    */         
/* 49 */         GAME.Warn("no race sound by the key of: " + key + System.lineSeparator() + a);
/* 50 */         this.debugged = true;
/*    */       } else {
/* 52 */         System.err.println("no race sound by the key of: " + key);
/*    */       } 
/*    */       
/* 55 */       return this.RDUMMY;
/*    */     } 
/*    */     
/* 58 */     return (SoundRace)this.rmap.tryGet(key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\SoundRaces.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */