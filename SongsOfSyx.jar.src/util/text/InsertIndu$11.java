/*     */ package util.text;
/*     */ 
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 140 */     super($anonymous0);
/*     */   }
/*     */   public void set(Induvidual a, Str str) {
/* 143 */     int ran = STATS.RAN().get(a, 128, 31);
/* 144 */     ran = MATH.mod(ran, WORLD.TAREA());
/* 145 */     int x = ran % WORLD.TWIDTH();
/* 146 */     int y = ran / WORLD.THEIGHT();
/*     */     
/* 148 */     Region r = (Region)(WORLD.REGIONS()).map.get(x, y);
/* 149 */     if (r == null) {
/*     */       int i;
/* 151 */       label20: for (i = 0; i < WORLD.TWIDTH(); i++) {
/* 152 */         for (DIR d : DIR.ALL) {
/* 153 */           r = (Region)(WORLD.REGIONS()).map.get(x + d.x() * i, y + d.y() * i);
/* 154 */           if (r != null) {
/*     */             break label20;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 160 */     if (r != null) {
/* 161 */       str.add((CharSequence)r.info.name());
/*     */     } else {
/* 163 */       str.add('?');
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertIndu$11.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */