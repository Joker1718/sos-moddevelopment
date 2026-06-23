/*     */ package settlement.stats.law;
/*     */ 
/*     */ import init.type.CRIMES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.rnd.RND;
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
/*     */ class null
/*     */   implements StatsInit.Addable
/*     */ {
/*     */   public void removePrivate(Induvidual i) {
/*  99 */     if (i.hType() == HTYPES.PRISONER()) {
/* 100 */       ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] = ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] - 1;
/* 101 */       CrimesData.this.count(i, -1);
/* 102 */       ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminalsTot--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 110 */     if (i.hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(i) != null) {
/* 111 */       ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] = ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] + 1;
/* 112 */       CrimesData.this.count(i, 1);
/* 113 */       ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminalsTot++;
/*     */     }
/* 115 */     else if ((STATS.LAW()).prisonerType.get(i) == null || ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).cl != i.clas()) {
/* 116 */       long m = 0L;
/* 117 */       for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/* 118 */         if (c.isCriminal())
/* 119 */           m += (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/*     */       } 
/* 121 */       m = (long)((float)m * RND.rFloat());
/* 122 */       for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/* 123 */         if (c.isCriminal())
/* 124 */           m -= (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/* 125 */         if (m <= 0L) {
/*     */           
/* 127 */           (STATS.LAW()).prisonerType.set(i, c);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\CrimesData$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */