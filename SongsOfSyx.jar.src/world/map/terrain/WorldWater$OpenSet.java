/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class OpenSet
/*     */ {
/*     */   private final COLOR cShore;
/*     */   private final COLOR cWater;
/* 316 */   private final ColorImp col = new ColorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final WorldWater.WATER normal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final WorldWater.WATER deep;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final WorldWater.WATER delta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final PLACABLE placer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SPRITE icon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final CharSequence name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_BOOLEAN is;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_BOOLEAN isOpen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ts, COLOR season) {
/* 408 */     this.col.set(this.cWater);
/* 409 */     this.col.multiply(season);
/*     */   }
/*     */   private OpenSet(String name, COLOR cShore, COLOR cWater, boolean isFertile) {
/* 412 */     this.is = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 416 */           return !(!WorldWater.OpenSet.this.normal.is(tx, ty) && !WorldWater.OpenSet.this.deep.is(tx, ty) && !WorldWater.OpenSet.this.delta.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 421 */           return !(!WorldWater.OpenSet.this.normal.is(tile) && !WorldWater.OpenSet.this.deep.is(tile) && !WorldWater.OpenSet.this.delta.is(tile));
/*     */         }
/*     */       };
/*     */     
/* 425 */     this.isOpen = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 429 */           return !(!WorldWater.OpenSet.this.normal.is(tx, ty) && !WorldWater.OpenSet.this.deep.is(tx, ty));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 434 */           return !(!WorldWater.OpenSet.this.normal.is(tile) && !WorldWater.OpenSet.this.deep.is(tile));
/*     */         }
/*     */       };
/*     */     this.cShore = cShore;
/*     */     this.cWater = cWater;
/*     */     this.name = name;
/*     */     this.delta = new WorldWater.Delta(paramWorldWater, name + " (" + name + ")", this);
/*     */     this.normal = new WorldWater.Normal(paramWorldWater, name + " (" + name + ")", this, isFertile);
/*     */     this.deep = new WorldWater.Deep(paramWorldWater, name + " (" + name + ")", this, isFertile);
/*     */     this.icon = (SPRITE)new SPRITE.Imp(32) {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*     */           ((WorldWater.Normal)WorldWater.OpenSet.this.normal).renderIcon(r, X1, Y1, X2 - X1);
/*     */         }
/*     */       };
/*     */     this.placer = (PLACABLE)new PlacableMulti(name, "", this.icon) {
/*     */         LinkedList<CLICKABLE> butts;
/*     */         WorldWater.WATER current;
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           this.current.place(tx, ty, area, type);
/*     */           WORLD.MINIMAP().updateRegion(null);
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           return this.current.isPlacable(tx, ty, area, type);
/*     */         }
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/*     */           return (LIST<CLICKABLE>)this.butts;
/*     */         }
/*     */         
/*     */         public PLACABLE getUndo() {
/*     */           return (PLACABLE)(WorldWater.OpenSet.access$0(WorldWater.OpenSet.this)).NOTHING;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWater$OpenSet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */