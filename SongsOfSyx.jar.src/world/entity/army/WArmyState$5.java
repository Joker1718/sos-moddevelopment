/*     */ package world.entity.army;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WArmyState
/*     */ {
/*     */   WArmyState update(WArmy a, double ds) {
/* 257 */     WArmy other = intercepting(a);
/*     */ 
/*     */ 
/*     */     
/* 261 */     if (other == null || !a.path().isValid()) {
/* 262 */       a.stateFloat = 0.0F;
/*     */ 
/*     */       
/* 265 */       return fortifying;
/*     */     } 
/*     */     
/* 268 */     if (a.path().destX() == other.ctx() && a.path().destY() == other.cty()) {
/* 269 */       if (a.path().remaining() > 0) {
/* 270 */         a.path().move(a, WArmy.speed * ds);
/* 271 */         return this;
/*     */       } 
/*     */       
/* 274 */       if (other.state() == fortifying || other.state() == fortified) {
/* 275 */         a.stateFloat = 0.0F;
/* 276 */         return fortifying;
/*     */       } 
/*     */ 
/*     */       
/* 280 */       return this;
/*     */     } 
/*     */     
/* 283 */     double dist = COORDINATE.tileDistance(a.path().destX(), a.path().destY(), other.ctx(), other.cty());
/*     */ 
/*     */     
/* 286 */     if (dist * 10.0D > a.path().remaining() && 
/* 287 */       !a.path().find(a.ctx(), a.cty(), other.ctx(), other.cty())) {
/* 288 */       a.stateFloat = 0.0F;
/* 289 */       return fortifying;
/*     */     } 
/*     */ 
/*     */     
/* 293 */     return this;
/*     */   }
/*     */   
/*     */   private WArmy intercepting(WArmy a) {
/* 297 */     if (a.stateShort != -1) {
/* 298 */       WArmy aa = (WORLD.ENTITIES()).armies.get(a.stateShort);
/* 299 */       if (aa == null || !aa.added()) {
/* 300 */         a.stateShort = -1;
/* 301 */         return null;
/*     */       } 
/* 303 */       return aa;
/*     */     } 
/* 305 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText info(WArmy a, GText box) {
/* 310 */     WArmy aa = intercepting(a);
/* 311 */     if (aa == null) {
/* 312 */       box.normalify();
/* 313 */       box.add(name(a));
/*     */     } else {
/* 315 */       GText text = box;
/* 316 */       text.color(GCOLOR.MAP().get(aa.faction()));
/* 317 */       text.add(Dic.¤¤Intercepting).insert(0, (CharSequence)aa.name);
/*     */     } 
/* 319 */     return box;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence name(WArmy a) {
/* 325 */     return Dic.¤¤Moving;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */