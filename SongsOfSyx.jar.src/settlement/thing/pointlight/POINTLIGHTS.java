/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public class POINTLIGHTS
/*     */   extends SETT.SettResource
/*     */ {
/*  21 */   private final PointMap map = new PointMap(SETT.TWIDTH, SETT.THEIGHT);
/*  22 */   final Sprites sprites = new Sprites();
/*     */   private final LOS_MAP los;
/*     */   
/*     */   public POINTLIGHTS() throws IOException {
/*  26 */     super("LIGHTS", true);
/*  27 */     LightModel.flickerr(0.0F);
/*  28 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("torch")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/*  32 */             POINTLIGHTS.this.torch(tx, ty, 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/*  37 */             return null;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  42 */     IDebugPanelSett.add((PLACABLE)new PlacableMulti("torch remove")
/*     */         {
/*     */           public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */           {
/*  46 */             POINTLIGHTS.this.remove(tx, ty);
/*     */           }
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/*  51 */             return null;
/*     */           }
/*     */         });
/*     */     
/*  55 */     this.los = new LOS_MAP();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  60 */     this.map.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  65 */     this.map.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  70 */     this.map.clear();
/*     */   }
/*     */   
/*     */   public void torch(int tx, int ty, int off) {
/*  74 */     this.map.add(tx, ty, off, off, LightModel.torch);
/*     */   }
/*     */   
/*     */   public void torchBig(int tx, int ty, int off) {
/*  78 */     this.map.add(tx, ty, off, off, LightModel.torch_big);
/*     */   }
/*     */   
/*     */   public void fire(int tx, int ty, int off) {
/*  82 */     this.map.add(tx, ty, off, off, LightModel.fire);
/*     */   }
/*     */   
/*     */   public void candle(int tx, int ty, int off) {
/*  86 */     this.map.add(tx, ty, off, off, LightModel.candle);
/*     */   }
/*     */   
/*     */   public void candle(int tx, int ty, int offx, int offy) {
/*  90 */     this.map.add(tx, ty, offx, offy, LightModel.candle);
/*     */   }
/*     */   
/*     */   public void remove(int tx, int ty) {
/*  94 */     this.map.remove(tx, ty);
/*     */   }
/*     */   
/*     */   public void hide(int tx, int ty, boolean hide) {
/*  98 */     this.map.hide(tx, ty, hide);
/*     */   }
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 102 */     return this.map.is(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {}
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 111 */     FireSparks.update(ds);
/* 112 */     LightModel.flickerr(ds);
/* 113 */     this.sprites.displacement.update(ds);
/* 114 */     this.sprites.texture.update(ds);
/* 115 */     this.map.render(r, s, ds, renWindow, offX, offY);
/*     */   }
/*     */   
/*     */   public void renderMouse(int x, int y, int offx, int offy, int rnd) {
/* 119 */     CORE.renderer().shadeLight(false);
/* 120 */     LightModel.mouse.register(CORE.renderer(), rnd, x, y, offx, offy);
/*     */   }
/*     */   
/*     */   public LOS_MAP los() {
/* 124 */     return this.los;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\POINTLIGHTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */