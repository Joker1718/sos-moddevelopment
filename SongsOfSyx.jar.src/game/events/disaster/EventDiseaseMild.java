/*     */ package game.events.disaster;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.time.TIME;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class EventDiseaseMild
/*     */   extends EVENTS.EventResource
/*     */ {
/*  21 */   private static CharSequence ¤¤titleF = "Disease at our doorstep!";
/*  22 */   private static CharSequence ¤¤descF = "There is rumour that the lands to the east have been ravaged by a deadly disease, leaving cities in ruins and emptying villages of the living. Let us hope it does not reach our lands.";
/*     */   
/*  24 */   private static CharSequence ¤¤title = "Epidemic!";
/*  25 */   private static CharSequence ¤¤desc = "It has come to us. The dreaded {0}. Nothing could have been done, it was the will of the gods. Lets hope our hospitals are well staffed. A curfew can be issued to contain it.";
/*     */   
/*     */   static {
/*  28 */     D.ts(EventDiseaseMild.class);
/*     */   }
/*     */   
/*  31 */   private final double maxTime = (256 * TIME.secondsPerDay());
/*  32 */   private double timer = 0.0D;
/*  33 */   private double ran = RND.rFloat();
/*     */   
/*     */   public EventDiseaseMild() {
/*  36 */     super("DISEASE_MILD");
/*  37 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  42 */     file.d(this.timer);
/*  43 */     file.d(this.ran);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  48 */     this.timer = file.d();
/*  49 */     this.ran = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  54 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  60 */     if (POP.tot(null, null) < 1000) {
/*     */       return;
/*     */     }
/*  63 */     double t = this.timer;
/*     */     
/*  65 */     this.timer += ds;
/*     */     
/*  67 */     if (t < this.maxTime - (TIME.secondsPerDay() * 4) && this.timer > this.maxTime - (TIME.secondsPerDay() * 4))
/*     */     {
/*  69 */       (new MessageText(¤¤titleF)).paragraph(¤¤descF).send();
/*     */     }
/*     */     
/*  72 */     if (this.timer < this.maxTime) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  78 */     DISEASE de = DISEASES.randomEpidemic(this.ran);
/*  79 */     reset();
/*     */     
/*  81 */     if (de == null || SETT.INVADOR().invading()) {
/*  82 */       this.timer -= TIME.secondsPerDay();
/*     */       
/*     */       return;
/*     */     } 
/*  86 */     double eff = 0.25D + 0.75D * POP.tot(null, null) / 20000.0D;
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (STATS.DISEASE().outbreak(de.infectRate * eff, de)) {
/*  91 */       MessageText te = new MessageText(¤¤title);
/*  92 */       Str.TMP.clear().add(¤¤desc).insert(0, de.info.name);
/*  93 */       te.paragraph((CharSequence)Str.TMP);
/*  94 */       Str.TMP.clear().add(de.info.name).NL().add(de.info.desc);
/*  95 */       te.paragraph((CharSequence)Str.TMP);
/*  96 */       te.send();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void reset() {
/* 102 */     this.timer = 0.0D;
/* 103 */     this.timer -= ((1.0F + RND.rFloat() * 2.0F) * TIME.secondsPerDay());
/* 104 */     this.ran = RND.rFloat();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventDiseaseMild.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */