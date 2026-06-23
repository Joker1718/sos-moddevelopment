/*     */ package game.values;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.keymap.MAPPED;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SAccumilator
/*     */   implements MAPPED
/*     */ {
/*     */   public final String key;
/*     */   private final boolean isBattle;
/*     */   private final int index;
/*     */   public final CharSequence name;
/*     */   
/*     */   SAccumilator(LISTE<SAccumilator> all, String key, boolean isBattle, CharSequence name) {
/* 197 */     this.index = all.add(this);
/* 198 */     this.key = "COUNT_" + key;
/* 199 */     this.isBattle = isBattle;
/* 200 */     this.name = name;
/* 201 */     GVALUES.FACTION.push(this.key + "_GAME", name, (SPRITE)(UI.icons()).s.pluses, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 205 */             return GCOUNTS.SAccumilator.this.current();
/*     */           }
/* 207 */         },  false);
/* 208 */     GVALUES.FACTION.push(this.key + "_ALL_TIME", String.valueOf(name) + " (" + String.valueOf(name) + ")", (SPRITE)(UI.icons()).s.pluses, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 212 */             return GCOUNTS.SAccumilator.this.allTimeHigh();
/*     */           }
/* 214 */         },  false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void inc(int delta) {
/* 220 */     if (this.isBattle || !VIEW.b().isActive()) {
/* 221 */       GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] + delta;
/* 222 */       GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] & Integer.MAX_VALUE;
/* 223 */       GCOUNTS.this.hi[this.index] = GCOUNTS.this.hi[this.index] + delta;
/* 224 */       GCOUNTS.this.hi[this.index] = GCOUNTS.this.hi[this.index] & Integer.MAX_VALUE;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void set(int a) {
/* 229 */     if (this.isBattle || !VIEW.b().isActive()) {
/* 230 */       GCOUNTS.this.value[this.index] = a;
/* 231 */       GCOUNTS.this.value[this.index] = GCOUNTS.this.value[this.index] & Integer.MAX_VALUE;
/* 232 */       if (GCOUNTS.this.value[this.index] > GCOUNTS.this.hi[this.index]) {
/* 233 */         GCOUNTS.this.hi[this.index] = GCOUNTS.this.value[this.index];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int allTimeHigh() {
/* 248 */     return Math.max(current(), hi());
/*     */   }
/*     */   
/*     */   public int current() {
/* 252 */     return GCOUNTS.this.value[this.index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hi() {
/* 268 */     return GCOUNTS.this.hi[this.index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 278 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String key() {
/* 285 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\values\GCOUNTS$SAccumilator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */