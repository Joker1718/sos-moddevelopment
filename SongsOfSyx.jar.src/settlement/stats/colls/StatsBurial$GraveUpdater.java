/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.keymap.MAPPED;
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
/*     */ class GraveUpdater
/*     */   implements StatsInit.StatUpdatable
/*     */ {
/*     */   private int[] available;
/*     */   private int[] needed;
/*     */   
/*     */   private GraveUpdater() {
/* 100 */     this.available = Alloc.ii(paramStatsBurial.graves.size());
/* 101 */     this.needed = Alloc.ii(paramStatsBurial.graves.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 106 */     for (StatsBurial.StatGrave gr : StatsBurial.this.graves) {
/* 107 */       this.available[gr.gIndex()] = (gr.grave()).total.get(null) * 100;
/*     */     }
/*     */     
/* 110 */     for (HCLASS c : HCLASSES.ALL()) {
/* 111 */       if (!c.player) {
/*     */         continue;
/*     */       }
/* 114 */       for (StatsBurial.StatGrave gr : StatsBurial.this.graves) {
/* 115 */         this.needed[gr.gIndex()] = 0;
/*     */       }
/*     */       
/* 118 */       for (Race r : RACES.all()) {
/* 119 */         for (StatsBurial.StatGrave gr : (r.service()).GRAVES.get(c.index())) {
/* 120 */           if (gr.grave().permission().get(c, r)) {
/* 121 */             this.needed[gr.gIndex()] = this.needed[gr.gIndex()] + POP.tot(c, r);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 126 */       for (Race r : RACES.all()) {
/* 127 */         for (StatsBurial.StatGrave gr : (r.service()).GRAVES.get(c.index())) {
/* 128 */           if (gr.grave().permission().get(c, r)) {
/* 129 */             gr.access.get((MAPPED)c).set((MAPPED)r, 0);
/*     */             
/* 131 */             int av = this.available[gr.gIndex()];
/* 132 */             int needed = this.needed[gr.gIndex()];
/* 133 */             if (av == 0) {
/* 134 */               gr.access.get((MAPPED)c).setD(r, 0.0D); continue;
/*     */             } 
/* 136 */             double d = av / (needed + 1);
/* 137 */             gr.access.get((MAPPED)c).setD(r, CLAMP.d(d, 0.0D, 1.0D));
/*     */             
/*     */             continue;
/*     */           } 
/* 141 */           gr.access.get((MAPPED)c).setD(r, 0.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBurial$GraveUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */