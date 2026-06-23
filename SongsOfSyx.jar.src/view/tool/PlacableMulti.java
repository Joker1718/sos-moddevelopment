/*     */ package view.tool;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public abstract class PlacableMulti
/*     */   implements PLACABLE {
/*     */   private final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   private final SPRITE icon;
/*     */   private final PLACABLE undo;
/*     */   PLACER_TYPE previous;
/*     */   int prevSize;
/*     */   
/*     */   public PlacableMulti(CharSequence name) {
/*  27 */     this(name, null, null, null);
/*     */   }
/*     */   
/*     */   public PlacableMulti(CharSequence name, CharSequence desc, SPRITE icon) {
/*  31 */     this(name, desc, icon, null);
/*     */   } public PlacableMulti(CharSequence name, CharSequence desc, SPRITE icon, PLACABLE undo) {
/*     */     Icon icon1;
/*     */     this.prevSize = -1;
/*  35 */     this.name = name;
/*  36 */     this.desc = desc;
/*  37 */     if (icon == null)
/*  38 */       icon1 = (SPRITES.icons()).m.cancel; 
/*  39 */     this.icon = (SPRITE)icon1;
/*  40 */     this.undo = undo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {}
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/*  49 */     return this.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/*  54 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/*  59 */     return this.undo;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverDesc(GBox box) {
/*  64 */     box.title(this.name);
/*  65 */     box.text(this.desc);
/*     */   }
/*     */   
/*     */   public CharSequence desc() {
/*  69 */     return this.desc;
/*     */   }
/*     */   
/*     */   public boolean canBePlacedAs(PLACER_TYPE t) {
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public boolean magicExpandTo(int fromX, int fromY, int toX, int toY) {
/*  81 */     if (VIEW.current() == VIEW.world() || VIEW.current() == (VIEW.world()).editor || VIEW.current() instanceof view.world.generator.WorldViewGenerator) {
/*  82 */       return (TERRAINS.world.get(fromX, fromY) == TERRAINS.world.get(toX, toY));
/*     */     }
/*  84 */     Terrain.TerrainTile t = SETT.TERRAIN().get(fromX, fromY);
/*  85 */     if (t.clearing().isEasilyCleared()) {
/*  86 */       Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(fromX, fromY);
/*  87 */       if (f != null) {
/*  88 */         return ((SETT.FLOOR()).getter.get(toX, toY) == f);
/*     */       }
/*  90 */       return ((SETT.FLOOR()).getter.get(toX, toY) == f && SETT.TERRAIN().get(toX, toY).clearing().isEasilyCleared());
/*     */     } 
/*     */ 
/*     */     
/*  94 */     if ((SETT.TERRAIN()).TREES.isTree(fromX, fromX) && (SETT.TERRAIN()).TREES.isTree(toX, toY))
/*  95 */       return true; 
/*  96 */     return (t == SETT.TERRAIN().get(toX, toY));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishPlacing(AREA placedArea) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishChecking(AREA placedArea) {}
/*     */ 
/*     */   
/*     */   public abstract CharSequence isPlacable(int paramInt1, int paramInt2, AREA paramAREA, PLACER_TYPE paramPLACER_TYPE);
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/* 112 */     return null;
/*     */   }
/*     */   public abstract void place(int paramInt1, int paramInt2, AREA paramAREA, PLACER_TYPE paramPLACER_TYPE);
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/* 116 */     if (isPlacable) {
/* 117 */       (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*     */     } else {
/* 119 */       (SPRITES.cons()).BIG.dashed_hollow.render(r, mask, x, y);
/*     */     } 
/*     */   }
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/* 123 */     if (a.body().width() > 1 && a.body().height() > 1) {
/* 124 */       GText t = b.text();
/* 125 */       t.add(a.body().width()).add('x').add(a.body().height()).adjustWidth();
/* 126 */       t.s().add('(').add(oktiles).add(')');
/* 127 */       b.add((SPRITE)t);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMulti.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */