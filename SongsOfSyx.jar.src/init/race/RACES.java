/*     */ package init.race;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.appearence.RaceSprites;
/*     */ import java.io.IOException;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.keymap.RMAPS;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RACES
/*     */ {
/*     */   private static RACES i;
/*     */   private final ArrayList<Race> all;
/*     */   private final ArrayList<Race> playable;
/*     */   private final RMAPS<Race> map;
/*     */   private RaceServiceSorter service;
/*  24 */   private static CharSequence ¤¤name = "¤Species";
/*     */   private RaceSprites sprites;
/*     */   private final RaceBoosts boosts;
/*     */   private RaceResources resources;
/*     */   
/*     */   static {
/*  30 */     D.ts(RACES.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public RACES() {
/*  35 */     i = this;
/*  36 */     PATH p = PATHS.INIT().getFolder("race");
/*  37 */     PATH pt = PATHS.TEXT().getFolder("race");
/*  38 */     String[] files = p.getFiles();
/*  39 */     this.all = new ArrayList(files.length);
/*     */ 
/*     */     
/*  42 */     if (files.length == 0)
/*  43 */       throw new Errors.DataError("no races defined!", p.get());  byte b;
/*     */     int i;
/*     */     String[] arrayOfString1;
/*  46 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String s = arrayOfString1[b]; b++; }
/*     */ 
/*     */ 
/*     */     
/*  50 */     int pl = 0;
/*  51 */     for (Race r : this.all) {
/*  52 */       if (r.playable)
/*  53 */         pl++; 
/*     */     } 
/*  55 */     this.map = new RMAPS("RACES", (LIST)this.all);
/*     */ 
/*     */     
/*  58 */     this.playable = new ArrayList(pl);
/*  59 */     for (Race r : this.all) {
/*  60 */       if (r.playable) {
/*  61 */         this.playable.add(r);
/*     */       }
/*     */     } 
/*  64 */     this.boosts = new RaceBoosts();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void expand() throws IOException {
/*  69 */     ExpandInit init = new ExpandInit();
/*     */     
/*  71 */     for (Race r : i.all) {
/*  72 */       r.expand(init);
/*     */     }
/*  74 */     RacePreferrence.init();
/*     */     
/*  76 */     i.sprites = new RaceSprites();
/*  77 */     i.resources = new RaceResources((LIST<Race>)i.all);
/*     */   }
/*     */   
/*     */   public static RaceResources res() {
/*  81 */     return i.resources;
/*     */   }
/*     */   
/*     */   public static LIST<Race> all() {
/*  85 */     return (LIST<Race>)i.all;
/*     */   }
/*     */   
/*     */   public static LIST<Race> playable() {
/*  89 */     return (LIST<Race>)i.playable;
/*     */   }
/*     */   
/*     */   public static RMAPS<Race> map() {
/*  93 */     return i.map;
/*     */   }
/*     */   
/*     */   public static RaceServiceSorter SERVICE() {
/*  97 */     return i.service;
/*     */   }
/*     */   
/*     */   public static CharSequence name() {
/* 101 */     return ¤¤name;
/*     */   }
/*     */   
/*     */   public static RaceSprites sprites() {
/* 105 */     return i.sprites;
/*     */   }
/*     */   
/*     */   public static RaceBoosts boosts() {
/* 109 */     return i.boosts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RACES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */