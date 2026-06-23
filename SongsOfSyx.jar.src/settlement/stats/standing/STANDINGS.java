/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ 
/*     */ public class STANDINGS
/*     */   extends SETT.SettResource
/*     */ {
/*     */   private static STANDINGS s;
/*     */   
/*     */   public static void create() {
/*  30 */     s = new STANDINGS();
/*     */   }
/*     */ 
/*     */   
/*  34 */   private final StandingCitizen happiness = new StandingCitizen(HCLASSES.CITIZEN(), (BOOSTABLES.BEHAVIOUR()).HAPPI, (BOOSTABLES.BEHAVIOUR()).LOYALTY);
/*  35 */   private final StandingCitizen submission = new StandingCitizen(HCLASSES.SLAVE(), (BOOSTABLES.BEHAVIOUR()).HAPPI_SLAVES, (BOOSTABLES.BEHAVIOUR()).SUBMISSION);
/*  36 */   private final StandingBuff buff = new StandingBuff();
/*     */   
/*     */   private STANDINGS() {
/*  39 */     super("STANDINGS", false);
/*     */ 
/*     */ 
/*     */     
/*  43 */     for (Race r : RACES.all()) {
/*  44 */       GVALUES.FACTION.push("LOYALTY_" + r.key, String.valueOf((this.happiness.loyalty.info()).name) + ": " + String.valueOf((this.happiness.loyalty.info()).name), (SPRITE)new SPRITE.Imp(24)
/*     */           {
/*     */             public void render(SPRITE_RENDERER re, int X1, int X2, int Y1, int Y2)
/*     */             {
/*  48 */               (r.appearance()).icon.render(re, X1, X2, Y1, Y2);
/*     */             }
/*  50 */           }new DOUBLE_O<Faction>()
/*     */           {
/*     */             public double getD(Faction t)
/*     */             {
/*  54 */               return STANDINGS.this.happiness.loyalty.getD(r);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  61 */     GVALUES.FACTION.push("LOYALTY", (this.happiness.loyalty.info()).name, (SPRITE)(UI.icons()).s.heart, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  65 */             return STANDINGS.this.happiness.current();
/*     */           }
/*     */         });
/*     */     
/*  69 */     GVALUES.FACTION.push("SUBMISSION_SLAVES", (this.submission.info()).name, (SPRITE)(UI.icons()).s.slave, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  73 */             return STANDINGS.this.submission.current();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  79 */     GAME.addBeforeGameStarts(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  83 */             STANDINGS.s.happiness.init();
/*  84 */             STANDINGS.s.submission.init();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  97 */     this.happiness.save(file);
/*  98 */     this.submission.save(file);
/*  99 */     this.buff.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 104 */     this.happiness.load(file);
/* 105 */     this.submission.load(file);
/* 106 */     if (!VERSION.versionIsBefore(71, 20)) {
/* 107 */       this.buff.saver.load(file);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clear() {
/* 112 */     this.happiness.clear();
/* 113 */     this.submission.clear();
/* 114 */     this.buff.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 119 */     this.happiness.update(ds);
/* 120 */     this.submission.update(ds);
/* 121 */     this.buff.update(ds);
/*     */   }
/*     */   
/*     */   public static StandingCitizen get(HCLASS c) {
/* 125 */     if (c == HCLASSES.CITIZEN())
/* 126 */       return s.happiness; 
/* 127 */     if (c == HCLASSES.SLAVE())
/* 128 */       return s.submission; 
/* 129 */     return s.happiness;
/*     */   }
/*     */   
/*     */   public static StandingCitizen CITIZEN() {
/* 133 */     return s.happiness;
/*     */   }
/*     */   
/*     */   public static StandingCitizen SLAVE() {
/* 137 */     return s.submission;
/*     */   }
/*     */   
/*     */   public static void emergency(HCLASS cl, double time) {
/* 141 */     s.buff.execute(cl, time);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\STANDINGS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */