/*     */ package init.type;
/*     */ 
/*     */ import init.race.Race;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final HCLASS_RACE[][] classes;
/*     */   private final ArrayList<HCLASS_RACE> all;
/* 179 */   private final ArrayListGrower<HCLASS_RACE> real = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   RClasses(LIST<Race> all) {
/* 183 */     this.all = new ArrayList((all.size() + 1) * (all.size() + 1));
/* 184 */     this.classes = new HCLASS_RACE[HCLASSES.ALL().size() + 1][all.size() + 1];
/*     */ 
/*     */     
/* 187 */     this.classes[0][0] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), null, null));
/* 188 */     for (Race r : all) {
/* 189 */       this.classes[0][r.index + 1] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), null, r));
/*     */     }
/*     */     
/* 192 */     for (HCLASS cl : HCLASSES.ALL()) {
/* 193 */       this.classes[cl.index() + 1][0] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), cl, null));
/* 194 */       for (Race r : all) {
/* 195 */         this.classes[cl.index() + 1][r.index + 1] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), cl, r));
/*     */       }
/*     */     } 
/*     */     
/* 199 */     for (HCLASS_RACE cl : this.all) {
/* 200 */       if (cl.cl != null && cl.race != null)
/* 201 */         this.real.add(cl); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HCLASS_RACE$RClasses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */