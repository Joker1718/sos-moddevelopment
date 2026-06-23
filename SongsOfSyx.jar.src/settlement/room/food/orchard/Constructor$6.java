/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends RoomSpriteXxX
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1, int $anonymous2) throws IOException {
/* 148 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 154 */     if (type().dx(data) == 0 || type().dy(data) == 0) {
/* 155 */       return false;
/*     */     }
/* 157 */     OTile t = blue.tile.get(it.tx(), it.ty());
/* 158 */     if (t != null) {
/* 159 */       OTile.STATE state = t.state();
/* 160 */       if (state == t.ISAPLING) {
/* 161 */         (SETT.TERRAIN()).BUSH.render(it, r, s, it.x() - 32, it.y() - 32, it.ran());
/* 162 */       } else if (state == t.ISMALL) {
/* 163 */         it.setOff(-32, -32);
/* 164 */         ssmall.render(r, s, data, it, degrade, isCandle);
/*     */       } 
/*     */     } else {
/* 167 */       (SETT.TERRAIN()).BUSH.render(it, r, s, it.x() - 32, it.y() - 32, it.ran());
/*     */     } 
/*     */     
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 176 */     OTile t = blue.tile.get(it.tx(), it.ty());
/* 177 */     if (t == null)
/*     */       return; 
/* 179 */     OTile.STATE state = t.state();
/* 180 */     if (state != t.IBIG && state != t.IDEAD) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 185 */     degrade = state.deadAmount();
/* 186 */     super.render(r, s, data, it, degrade, false);
/* 187 */     int dx = 16 - 32 * type().dx(data) + it.oX();
/* 188 */     int dy = 16 - 32 * type().dy(data) + it.oY();
/* 189 */     it.setOff(dx, dy);
/*     */     
/* 191 */     Instance ins = (Instance)blue.getter.get(it.tile());
/* 192 */     double a = 4.0D * state.fruitAmount() * Constructor.this.fertility.get(ins) * ins.skill() * blue.time.fruit();
/* 193 */     int am = (int)a;
/*     */     
/* 195 */     for (int i = 0; i < am; i++) {
/* 196 */       it.ranOffset(i, 0);
/* 197 */       sfruit.render(r, s, data, it, degrade, false);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Constructor$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */