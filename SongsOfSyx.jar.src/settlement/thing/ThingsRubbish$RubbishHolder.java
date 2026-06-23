/*     */ package settlement.thing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RubbishHolder
/*     */   extends THINGS.ThingFactory<ThingsRubbish.ThingRubbish>
/*     */ {
/* 131 */   private final ThingsRubbish.ThingRubbish[] gore = new ThingsRubbish.ThingRubbish[5000];
/* 132 */   private final IUpdater up = new IUpdater(5000, TIME.secondsPerDay())
/*     */     {
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/* 136 */         ThingsRubbish.ThingRubbish r = ThingsRubbish.RubbishHolder.this.gore[i];
/*     */         
/* 138 */         if (!r.isRemoved()) {
/* 139 */           int hour = r.age();
/* 140 */           if (hour >= TIME.hoursPerDay())
/* 141 */             r.remove(); 
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   RubbishHolder(LISTE<THINGS.ThingFactory<?>> all) {
/* 147 */     super(all, 5000);
/* 148 */     for (int i = 0; i < this.gore.length; i++) {
/* 149 */       this.gore[i] = new ThingsRubbish.ThingRubbish(i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void make(int cx, int cy) {
/* 154 */     ThingsRubbish.ThingRubbish f = nextInLine();
/* 155 */     f.init(cx, cy, (byte)(RND.rInt() & 0xFF));
/* 156 */     f.add();
/*     */   }
/*     */   
/*     */   public void make(int cx, int cy, byte ran) {
/* 160 */     ThingsRubbish.ThingRubbish f = nextInLine();
/* 161 */     f.init(cx, cy, ran);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 166 */     this.up.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 171 */     this.up.save(file);
/* 172 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 177 */     this.up.load(file);
/* 178 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 183 */     this.up.clear();
/* 184 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ThingsRubbish.ThingRubbish[] all() {
/* 189 */     return this.gore;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsRubbish$RubbishHolder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */