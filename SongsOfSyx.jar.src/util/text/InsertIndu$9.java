/*     */ package util.text;
/*     */ 
/*     */ import init.type.TRAIT;
/*     */ import init.type.TRAITS;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Inserter<Induvidual>.II
/*     */ {
/*     */   null(Inserter paramInserter, String $anonymous0) {
/* 108 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void set(Induvidual a, Str str) {
/* 112 */     LIST<TRAIT> tt = TRAITS.tmp(a, 4);
/* 113 */     int am = tt.size();
/*     */     
/* 115 */     if (am > 1) {
/* 116 */       for (TRAIT i : tt) {
/* 117 */         str.add(i.info.name);
/* 118 */         am--;
/* 119 */         if (am == 1) {
/* 120 */           str.s().add(Dic.¤¤and).s(); continue;
/* 121 */         }  if (am > 1)
/* 122 */           str.add(',').s(); 
/*     */       } 
/*     */     } else {
/* 125 */       for (TRAIT i : tt)
/* 126 */         str.add(i.info.name); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertIndu$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */