/*     */ package game.events.disaster;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class EventDisease
/*     */   extends EVENTS.EventResource {
/*  27 */   private static CharSequence ¤¤title = "Outbreak!";
/*  28 */   private static CharSequence ¤¤desc = "Dreadful news! On account of poor health and sanitation, an epidemic of {0} has been discovered. Lets hope our hospitals are well staffed. A curfew can be issued to contain it.";
/*     */   
/*     */   static {
/*  31 */     D.ts(EventDisease.class);
/*     */   }
/*     */   
/*  34 */   private final double maxTime = (8 * TIME.secondsPerDay());
/*  35 */   private double timer = 1.0D;
/*  36 */   private double ran = RND.rFloat();
/*  37 */   private double spread = 0.0D;
/*  38 */   private double warmup = 0.25D;
/*     */ 
/*     */ 
/*     */   
/*     */   public EventDisease() {
/*  43 */     super("DISEASE");
/*  44 */     reset();
/*     */     
/*  46 */     IDebugPanelSett.add("EVENT DISEASE", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  50 */             EventDisease.this.set();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  59 */     file.d(this.timer);
/*  60 */     file.d(this.spread);
/*  61 */     file.d(this.ran);
/*  62 */     file.d(this.warmup);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  67 */     this.timer = file.d();
/*  68 */     this.spread = file.d();
/*  69 */     this.ran = file.d();
/*  70 */     this.warmup = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  75 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  81 */     double d = 1.0D - (BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*  82 */     if (d < 0.0D) {
/*  83 */       this.timer += ds;
/*  84 */       this.timer = CLAMP.d(this.timer, 0.0D, 16.0D * TIME.secondsPerDay());
/*     */       
/*     */       return;
/*     */     } 
/*  88 */     this.timer -= ds * d;
/*     */     
/*  90 */     if (this.timer < 0.0D) {
/*  91 */       set();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void set() {
/*  98 */     DISEASE de = DISEASES.randomEpidemic(this.ran);
/*     */     
/* 100 */     if (de == null || SETT.INVADOR().invading()) {
/* 101 */       this.timer += 0.1D;
/*     */       
/*     */       return;
/*     */     } 
/* 105 */     this.warmup = CLAMP.d(this.warmup, 0.25D, 1.0D);
/*     */     
/* 107 */     double o = this.warmup * this.spread * de.infectRate;
/* 108 */     this.warmup += this.warmup;
/*     */ 
/*     */     
/* 111 */     if (STATS.DISEASE().outbreak(o, de)) {
/* 112 */       MessageText te = new MessageText(¤¤title);
/* 113 */       Str.TMP.clear().add(¤¤desc).insert(0, de.info.name);
/* 114 */       te.paragraph((CharSequence)Str.TMP);
/* 115 */       Str.TMP.clear().add(de.info.name).NL().add(de.info.desc);
/* 116 */       te.paragraph((CharSequence)Str.TMP);
/* 117 */       te.send();
/* 118 */       STANDINGS.emergency(HCLASSES.CITIZEN(), (TIME.secondsPerDay() * 8));
/*     */     } 
/*     */     
/* 121 */     reset();
/*     */   }
/*     */   
/*     */   private void reset() {
/* 125 */     this.timer = this.maxTime;
/* 126 */     this.timer *= (1.0F + RND.rFloat() * 2.0F);
/* 127 */     this.ran = RND.rFloat();
/* 128 */     this.spread = 0.6D + 0.4D * RND.rFloat();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventDisease.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */