/*    */ package game.audio;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.keymap.RMAP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Ambiances
/*    */ {
/*    */   private final RMAP<Ambiance> rmap;
/*    */   public final Ambiance nature;
/*    */   public final Ambiance wind;
/*    */   public final Ambiance night;
/*    */   public final Ambiance water;
/*    */   public final Ambiance rain;
/*    */   public final Ambiance windTrees;
/*    */   public final Ambiance windhowl;
/*    */   public final Ambiance thunder;
/*    */   public final AudioFactory<SoundStream> factory;
/*    */   private boolean debugged = false;
/*    */   
/*    */   Ambiances() {
/* 34 */     this.factory = new AudioFactory<SoundStream>("AMBIANCE", (PATHS.AUDIO()).ambience, (SoundStream)new SoundStream.Dummy())
/*    */       {
/*    */         
/*    */         protected SoundStream create(LinkedList<SoundStream> all, Path p, String key)
/*    */         {
/* 39 */           return CORE.getSoundCore().getStream(p, false);
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 44 */     LinkedList<Ambiance> all = new LinkedList();
/*    */     
/* 46 */     PATH p = (PATHS.AUDIO()).config.getFolder("ambience"); byte b; int i; String[] arrayOfString;
/* 47 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String file = arrayOfString[b];
/* 48 */       Json json = new Json(p.gets(file));
/* 49 */       LIST<String> keys = json.keys();
/*    */       
/* 51 */       for (String k : keys);
/*    */ 
/*    */       
/*    */       b++; }
/*    */ 
/*    */     
/* 57 */     this.rmap = new RMAP("AMBIENCE", (LIST)all);
/*    */ 
/*    */ 
/*    */     
/* 61 */     this.nature = get("NATURE");
/* 62 */     this.wind = get("WIND");
/* 63 */     this.night = get("NIGHT");
/* 64 */     this.water = get("WATER");
/* 65 */     this.rain = get("RAIN");
/* 66 */     this.windTrees = get("WIND_TREES");
/* 67 */     this.windhowl = get("CAVE");
/* 68 */     this.thunder = get("THUNDER");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Ambiance get(String key) {
/* 74 */     if (this.rmap.tryGet(key) == null) {
/* 75 */       if (!this.debugged) {
/* 76 */         String a = "Available " + System.lineSeparator();
/* 77 */         for (String s : this.rmap.available()) {
/* 78 */           a = a + a + s;
/*    */         }
/*    */         
/* 81 */         GAME.Warn("no ambiance sound by the key of: " + key + System.lineSeparator() + a);
/* 82 */         this.debugged = true;
/*    */       } else {
/* 84 */         System.err.println("no ambiance sound  by the key of: " + key);
/*    */       } 
/*    */       
/* 87 */       return null;
/*    */     } 
/*    */     
/* 90 */     return (Ambiance)this.rmap.tryGet(key);
/*    */   }
/*    */   
/*    */   public LIST<Ambiance> all() {
/* 94 */     return this.rmap.all();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\Ambiances.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */