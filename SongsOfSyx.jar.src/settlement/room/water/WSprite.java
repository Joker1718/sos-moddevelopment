/*     */ package settlement.room.water;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ final class WSprite
/*     */ {
/*     */   private final ROOM_WATER w;
/*  34 */   private final ColorImp col = new ColorImp(20, 40, 100);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET stencil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET sroad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET edge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET sbridge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_BOOLEAN willConnectable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int edgeMask, int flowMask, boolean bridge) {
/*  88 */     boolean bb = false;
/*  89 */     for (DIR d : DIR.ORTHO) {
/*  90 */       if (this.willConnectable.is(it.tx(), it.ty(), d)) {
/*  91 */         edgeMask |= d.mask(); continue;
/*  92 */       }  if (bridge && !bb && !(SETT.PATH()).solidity.is(it.tx(), it.ty(), d) && (SETT.FLOOR()).getter.is(it.tx(), it.ty(), d)) {
/*  93 */         d = d.perpendicular();
/*  94 */         if (!(SETT.PATH()).solidity.is(it.tx(), it.ty(), d) && (SETT.FLOOR()).getter.is(it.tx(), it.ty(), d)) {
/*  95 */           bb = true;
/*     */         }
/*     */       } 
/*     */     } 
/*  99 */     int steI = edgeMask;
/* 100 */     edgeMask += 16 * (it.ran() & 0x3);
/* 101 */     this.edge.render(r, edgeMask, it.x(), it.y());
/*     */     
/* 103 */     TextureCoords ste = bb ? this.sroad.getTexture(steI) : this.stencil.getTexture(steI);
/* 104 */     CORE.renderer().setMaxDepth(it.x(), it.x() + 64, it.y(), it.y() + 64, ste, CORE.renderer().getDepth() + 1);
/*     */ 
/*     */     
/* 107 */     GroundType g = (GroundType)(SETT.GROUND()).MAP.get(it.tile());
/* 108 */     ColorImp.TMP.set(g.col(it.tile()));
/* 109 */     ColorImp.TMP.shadeSelf(0.8D);
/* 110 */     ColorImp.TMP.bind();
/* 111 */     this.stencil.renderTextured(SETT.GROUND().getTexture(it.tile(), it.ran()), steI, it.x(), it.y());
/* 112 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     if (flowMask != 0) {
/* 118 */       int ms = 0;
/* 119 */       int am = 0;
/* 120 */       for (DIR d : DIR.ORTHO) {
/* 121 */         if ((d.mask() & flowMask) != 0) {
/* 122 */           am++;
/*     */         }
/* 124 */         int dx = it.tx() + d.x();
/* 125 */         int dy = it.ty() + d.y();
/* 126 */         if (!this.w.pumpable.is(dx, dy) || ((RoomPumpable)this.w.pumpable.get(dx, dy)).dirmask(dx, dy) != 0) {
/* 127 */           ms |= d.mask();
/*     */         }
/*     */       } 
/*     */       
/* 131 */       int op = 255 / (am + 1);
/* 132 */       OpacityImp.TMP.set(op);
/* 133 */       OpacityImp.TMP.bind();
/* 134 */       this.col.bind();
/*     */       
/* 136 */       double dd = TIME.currentSecond() * 12.0D;
/* 137 */       ms &= steI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 143 */       for (DIR d : DIR.ORTHO) {
/* 144 */         if ((d.mask() & flowMask) != 0) {
/* 145 */           TextureCoords tex = (SPRITES.textures()).dis_small.get((it.tx() * 16) + dd * -d.x(), (it.ty() * 16) + dd * -d.y());
/* 146 */           this.stencil.renderTextured(tex, ms, it.x(), it.y());
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 153 */       OPACITY.unbind();
/* 154 */       COLOR.unbind();
/*     */     } 
/*     */     
/* 157 */     if (bb) {
/* 158 */       this.sbridge.render(r, it.ran() & 0x7, it.x(), it.y());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderWater(SPRITE_RENDERER r, RenderData.RenderIterator it, TILE_SHEET stencil, int tm, int op) {
/* 167 */     GroundType g = (GroundType)(SETT.GROUND()).MAP.get(it.tile());
/* 168 */     ColorImp.TMP.set(g.col(it.tile()));
/* 169 */     ColorImp.TMP.shadeSelf(0.8D);
/* 170 */     ColorImp.TMP.bind();
/* 171 */     stencil.renderTextured(SETT.GROUND().getTexture(it.tile(), it.ran()), tm, it.x(), it.y());
/* 172 */     COLOR.unbind();
/*     */ 
/*     */     
/* 175 */     OpacityImp.TMP.set(op);
/* 176 */     OpacityImp.TMP.bind();
/* 177 */     this.col.bind();
/*     */     
/* 179 */     double dd = TIME.currentSecond() * 12.0D;
/*     */     
/* 181 */     for (DIR d : DIR.ORTHO) {
/* 182 */       TextureCoords tex = (SPRITES.textures()).dis_small.get((it.tx() * 16) + dd * -d.x(), (it.ty() * 16) + dd * -d.y());
/* 183 */       stencil.renderTextured(tex, tm, it.x(), it.y());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 188 */     OPACITY.unbind();
/* 189 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int edgeMask, boolean bridge) {
/* 194 */     boolean bb = false;
/* 195 */     for (DIR d : DIR.ORTHO) {
/* 196 */       if (this.willConnectable.is(it.tx(), it.ty(), d)) {
/* 197 */         edgeMask |= d.mask();
/*     */         continue;
/*     */       } 
/* 200 */       if (bridge && !bb && !(SETT.PATH()).solidity.is(it.tx(), it.ty(), d) && (SETT.FLOOR()).getter.is(it.tx(), it.ty(), d)) {
/* 201 */         d = d.perpendicular();
/* 202 */         if (!(SETT.PATH()).solidity.is(it.tx(), it.ty(), d) && (SETT.FLOOR()).getter.is(it.tx(), it.ty(), d)) {
/* 203 */           bb = true;
/*     */         }
/*     */       } 
/*     */     } 
/* 207 */     edgeMask += 16 * (it.ran() & 0x3);
/*     */     
/* 209 */     s.setHeight(2).setDistance2Ground(0.0D);
/* 210 */     this.edge.render((SPRITE_RENDERER)s, edgeMask, it.x(), it.y());
/*     */     
/* 212 */     if (bb) {
/* 213 */       this.sbridge.render((SPRITE_RENDERER)s, it.ran() & 0x7, it.x(), it.y());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int tx, int ty) {
/* 223 */     int data = 0;
/* 224 */     for (DIR d : DIR.ORTHO) {
/* 225 */       if (this.willConnectable.is(tx, ty, d))
/* 226 */         data |= d.mask(); 
/*     */     } 
/* 228 */     (SPRITES.cons()).BIG.outline.render(r, data, x, y);
/*     */   }
/*     */   
/* 231 */   WSprite(ROOM_WATER w, RoomInitData init) throws IOException { this.willConnectable = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 235 */           RoomBlueprintImp b = (RoomBlueprintImp)(SETT.ROOMS()).map.blueprintImp.get(tx, ty);
/* 236 */           if (b == WSprite.this.w.canal || b == WSprite.this.w.drain)
/* 237 */             return true; 
/* 238 */           if (b == WSprite.this.w.pump) {
/* 239 */             return WSprite.this.w.pump.isCanalConnection(tx, ty);
/*     */           }
/* 241 */           return false;
/*     */         }
/*     */         
/*     */         public boolean is(int tile)
/*     */         {
/* 246 */           throw new RuntimeException(); } }; this.w = w; this.edge = (new ComposerThings.ITileSheet(init.gSprite.get("CANAL"), 288, 172) { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.house.init(0, 0, 2, 2, (ComposerDests.Dest)d.s16); s.house.setVar(0).paste(true); s.house.setVar(0).pasteRotated(1, true); s.house.setVar(1).paste(true); s.house.setVar(1).pasteRotated(1, true); return d.s16.saveGame(); } }
/*     */       ).get();
/*     */     this.stencil = (new ComposerThings.ITileSheet() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.house.setVar(2).paste(true);
/*     */           return d.s16.saveGame(); } }
/*     */       ).get();
/*     */     this.sroad = (new ComposerThings.ITileSheet() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.house.setVar(3).paste(true);
/*     */           return d.s16.saveGame(); } }
/*     */       ).get();
/*     */     this.sbridge = (new ComposerThings.ITileSheet() { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.singles.init(0, s.house.body().y2(), 1, 1, 2, 1, (ComposerDests.Dest)d.s16).paste(3, true);
/*     */           return d.s16.saveGame(); } }
/* 256 */       ).get(); } public static class RSprite implements RoomSprite { private final RoomBlueprintImp blue; RSprite(RoomBlueprintImp blue, RoomPumpable pump, boolean bridge) { this.blue = blue;
/* 257 */       this.pump = pump;
/* 258 */       this.bridge = bridge; }
/*     */     
/*     */     private final RoomPumpable pump; private boolean bridge;
/*     */     
/*     */     public int sData() {
/* 263 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 269 */       (SETT.ROOMS()).WATER.sprite.renderPlaceholder(r, x, y, tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 275 */       data = 0;
/* 276 */       for (DIR d : DIR.ORTHO) {
/* 277 */         if ((SETT.ROOMS()).WATER.sprite.willConnectable.is(it.tx(), it.ty(), d))
/* 278 */           data |= d.mask(); 
/*     */       } 
/* 280 */       (SETT.ROOMS()).WATER.sprite.renderBelow(r, s, it, data, this.bridge);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 287 */       int edge = 0;
/* 288 */       for (DIR d : DIR.ORTHO) {
/* 289 */         if ((SETT.ROOMS()).WATER.sprite.willConnectable.is(it.tx(), it.ty(), d))
/* 290 */           data |= d.mask(); 
/*     */       } 
/* 292 */       int flow = this.blue.is(it.tile()) ? this.pump.dirmask(it.tx(), it.ty()) : 0;
/*     */       
/* 294 */       (SETT.ROOMS()).WATER.sprite.render(r, s, it, edge, flow, this.bridge);
/*     */       
/* 296 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 301 */       return 0;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\WSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */