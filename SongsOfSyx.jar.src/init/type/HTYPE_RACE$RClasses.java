/*     */ package init.type;
/*     */ 
/*     */ import init.race.Race;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RClasses
/*     */ {
/*     */   private final LIST<HTYPE_RACE> all;
/*     */   private final LIST<HTYPE_RACE> allReal;
/*     */   private final HTYPE_RACE[][] classes;
/*     */   
/*     */   RClasses(LIST<Race> races, LIST<HTYPE> types) {
/* 101 */     this.classes = new HTYPE_RACE[types.size() + 1][races.size() + 1];
/* 102 */     ArrayList<HTYPE_RACE> all = new ArrayList((races.size() + 1) * (types.size() + 1));
/* 103 */     ArrayList<HTYPE_RACE> real = new ArrayList(races.size() * types.size());
/* 104 */     for (Race r : races) {
/* 105 */       for (HTYPE cl : types) {
/* 106 */         HTYPE_RACE hTYPE_RACE = new HTYPE_RACE(all.size(), cl, r);
/* 107 */         all.add(hTYPE_RACE);
/* 108 */         real.add(hTYPE_RACE);
/*     */       } 
/*     */     } 
/* 111 */     for (Race r : races) {
/* 112 */       all.add(new HTYPE_RACE(all.size(), null, r));
/*     */     }
/* 114 */     for (HTYPE cl : types) {
/* 115 */       HTYPE_RACE hTYPE_RACE = new HTYPE_RACE(all.size(), cl, null);
/* 116 */       all.add(hTYPE_RACE);
/*     */     } 
/* 118 */     HTYPE_RACE t = new HTYPE_RACE(all.size(), null, null);
/* 119 */     all.add(t);
/*     */     
/* 121 */     for (HTYPE_RACE tt : all) {
/* 122 */       int ci = (tt.cl == null) ? 0 : (tt.cl.index() + 1);
/* 123 */       int ri = (tt.race == null) ? 0 : (tt.race.index + 1);
/* 124 */       this.classes[ci][ri] = tt;
/*     */     } 
/*     */ 
/*     */     
/* 128 */     this.all = (LIST<HTYPE_RACE>)all;
/* 129 */     this.allReal = (LIST<HTYPE_RACE>)real;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HTYPE_RACE$RClasses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */