/*     */ package settlement.room.water.pool;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.GUTIL;
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
/*     */ final class CanalConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final boolean clearFer;
/*     */   
/*     */   protected CanalConstructor(RoomInitData init) throws IOException {
/* 161 */     super(init, 1, 0);
/*     */     
/* 163 */     Json sp = init.data().json("SPRITES");
/*     */     
/* 165 */     final ColorImp color = new ColorImp(init.data(), "WATER_COLOR");
/* 166 */     final OpacityImp opacity = new OpacityImp((int)(init.data().d("WATER_DEPTH", 0.0D, 1.0D) * 255.0D));
/* 167 */     this.clearFer = init.data().bool("CLEARS_GRASS");
/*     */     
/* 169 */     final TILE_SHEET bottom = SPRITES.GAME().raw((SheetType)SheetType.sTex, "BOTTOM_TEXTURE", init.data());
/*     */     
/* 171 */     RoomSpriteCombo s = new RoomSpriteCombo(sp, "FRAME_COMBO", sp)
/*     */       {
/*     */         final RoomSprite1x1 ontop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         final RoomSpriteCombo stencil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 186 */           data = 0;
/* 187 */           for (DIR d : DIR.ORTHO) {
/* 188 */             if ((SETT.ROOMS()).map.blueprintImp.get(tx, ty, d) == ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this))
/* 189 */               data |= d.mask(); 
/*     */           } 
/* 191 */           (SPRITES.cons()).BIG.outline.render(r, data, x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 196 */           data = getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile()));
/* 197 */           super.render(SPRITE_RENDERER.DUMMY, s, data, it, degrade, false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderB(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 203 */           data = getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile())) & 0xF;
/* 204 */           TextureCoords tex = this.stencil.texture(data, it);
/*     */           
/* 206 */           int x2 = it.x() + 64;
/* 207 */           int y2 = it.y() + 64;
/*     */           
/* 209 */           CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, bottom.getTexture(it.ran() % bottom.tiles()), tex);
/*     */ 
/*     */           
/* 212 */           if ((SETT.ROOMS()).map.get(it.tile()) != (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance || ((SETT.ROOMS()).extraBit.get(it.tile()) & 0x1) != 1) {
/*     */             return;
/*     */           }
/* 215 */           data = this.stencil.getData(it.tx(), it.ty(), 0, 0, null, GUTIL.ran2().get(it.tile())) & 0xF;
/* 216 */           tex = this.stencil.texture(data, it);
/* 217 */           color.bind();
/* 218 */           opacity.bind();
/* 219 */           TextureCoords oo = (SPRITES.textures()).dis_small.get((it.tx() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D, (it.ty() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D);
/* 220 */           CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, oo, tex);
/* 221 */           oo = (SPRITES.textures()).dis_small.get(((it.tx() + 1) * 16) - 8.0D * TIME.currentSecond(), ((it.ty() + 1) * 16) - 8.0D * TIME.currentSecond());
/* 222 */           CORE.renderer().renderTextured(it.x(), x2, it.y(), y2, oo, tex);
/* 223 */           COLOR.unbind();
/* 224 */           OPACITY.unbind();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 232 */           return ((SETT.ROOMS()).map.get(tx, ty) == (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 238 */           renderB(r, s, data, it, degrade);
/* 239 */           data = 0;
/* 240 */           int iceMask = 0;
/* 241 */           for (DIR d : DIR.ORTHO) {
/* 242 */             if ((SETT.ROOMS()).map.get(it.tx(), it.ty(), d) == (ROOM_POOL.CanalConstructor.access$0(ROOM_POOL.CanalConstructor.this)).instance) {
/* 243 */               data |= d.mask();
/* 244 */               if (((SETT.ROOMS()).extraBit.get(it.tx(), it.ty()) & 0x1) == 1 && (SETT.TERRAIN()).WATER.is.is(it.tx() + d.x(), it.ty() + d.y())) {
/* 245 */                 iceMask |= d.mask();
/*     */               }
/*     */             } 
/*     */           } 
/* 249 */           if ((SETT.TERRAIN()).WATER.ice.is(it.tx(), it.ty())) {
/* 250 */             (SETT.TERRAIN()).WATER.renderIce(it, iceMask);
/* 251 */             super.render(r, ShadowBatch.DUMMY, data, it, degrade, isCandle);
/*     */           } else {
/*     */             
/* 254 */             super.render(r, ShadowBatch.DUMMY, data, it, degrade, isCandle);
/* 255 */             this.ontop.render(r, s, getData2(it), it, degrade, false);
/*     */           } 
/*     */ 
/*     */           
/* 259 */           data = getData(it.tx(), it.ty(), 0, 0, null, 0);
/* 260 */           TextureCoords tex = this.stencil.texture(data, it);
/* 261 */           CORE.renderer().setMaxDepth(it.x(), it.x() + 64, it.y(), it.y() + 64, tex, CORE.renderer().getDepth() + 1);
/*     */ 
/*     */           
/* 264 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 273 */     flush(1, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 279 */     return this.clearFer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 285 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 290 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 300 */     int tx = area.mX();
/* 301 */     int ty = area.my();
/* 302 */     ROOM_POOL.this.instance.place(area);
/* 303 */     (SETT.ROOMS()).fData.spriteData2.set(tx, ty, 1);
/* 304 */     for (DIR d : DIR.ORTHO) {
/* 305 */       if (ROOM_POOL.this.is(tx, ty, d)) {
/* 306 */         (SETT.ROOMS()).fData.spriteData2.set(tx, ty, d, 1);
/*     */       }
/*     */     } 
/*     */     
/* 310 */     return (SETT.ROOMS()).map.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 315 */     return ROOM_POOL.this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSpecialAreaPlacable() {
/* 320 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\pool\ROOM_POOL$CanalConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */