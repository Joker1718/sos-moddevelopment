/*     */ package settlement.thing;
/*     */ 
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SpecialHolder
/*     */ {
/* 202 */   private final int[] amounts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 203 */   private final int[] amountsPlayer = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 204 */   private final int[] firsts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/* 205 */   private final int[] lasts = Alloc.ii(CAUSE_LEAVES.DEATHS().size());
/*     */ 
/*     */   
/*     */   void add(ThingsCorpses.Corpse corpse) {
/* 209 */     int i = corpse.cause.indexDeath;
/* 210 */     corpse.sParent = -1;
/* 211 */     corpse.sNext = -1;
/* 212 */     if (this.firsts[i] == -1) {
/* 213 */       this.firsts[i] = corpse.index();
/* 214 */       this.lasts[i] = corpse.index();
/*     */     } else {
/* 216 */       (ThingsCorpses.this.corpses[this.lasts[i]]).sNext = corpse.index();
/* 217 */       corpse.sParent = ThingsCorpses.this.corpses[this.lasts[i]].index();
/* 218 */       this.lasts[i] = corpse.index();
/*     */     } 
/* 220 */     this.amounts[i] = this.amounts[i] + 1;
/* 221 */     if (corpse.indu.player()) {
/* 222 */       this.amountsPlayer[i] = this.amountsPlayer[i] + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   void remove(ThingsCorpses.Corpse corpse) {
/* 227 */     int i = corpse.cause.indexDeath;
/* 228 */     if (corpse.sParent != -1) {
/* 229 */       (ThingsCorpses.this.corpses[corpse.sParent]).sNext = corpse.sNext;
/*     */     }
/* 231 */     if (corpse.sNext != -1) {
/* 232 */       (ThingsCorpses.this.corpses[corpse.sNext]).sParent = corpse.sParent;
/*     */     }
/* 234 */     if (this.firsts[i] == corpse.index())
/* 235 */       this.firsts[i] = corpse.sNext; 
/* 236 */     if (this.lasts[i] == corpse.index()) {
/* 237 */       this.lasts[i] = corpse.sParent;
/*     */     }
/* 239 */     corpse.sNext = -1;
/* 240 */     corpse.sParent = -1;
/* 241 */     this.amounts[i] = this.amounts[i] - 1;
/* 242 */     if (corpse.indu.player())
/* 243 */       this.amountsPlayer[i] = this.amountsPlayer[i] - 1; 
/*     */   }
/*     */   
/*     */   int amount(CAUSE_LEAVE l) {
/* 247 */     if (!l.death)
/* 248 */       return 0; 
/* 249 */     return this.amountsPlayer[l.indexDeath];
/*     */   }
/*     */   
/*     */   public ThingsCorpses.Corpse getFirst(CAUSE_LEAVE l) {
/* 253 */     if (this.firsts[l.indexDeath] != -1)
/* 254 */       return ThingsCorpses.this.corpses[this.firsts[l.indexDeath]]; 
/* 255 */     return null;
/*     */   }
/*     */   
/*     */   public ThingsCorpses.Corpse getNext(ThingsCorpses.Corpse corpse) {
/* 259 */     if (corpse.sNext == -1)
/* 260 */       return null; 
/* 261 */     return ThingsCorpses.this.corpses[corpse.sNext];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCorpses$SpecialHolder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */