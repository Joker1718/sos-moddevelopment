/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.world.generator.tools.UIWorldToolCapitolPlaceInfo;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placer
/*     */   extends ArrayListGrower<PLACABLE>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  48 */   private final INT.IntImp ii = new INT.IntImp(1, 1022);
/*  49 */   private static CharSequence ¤¤name = "Place Player";
/*  50 */   private static CharSequence ¤¤locate = "locate";
/*  51 */   private static CharSequence ¤¤removeC = "Remove Completely";
/*  52 */   private static CharSequence ¤¤remove = "Remove";
/*  53 */   private static CharSequence ¤¤namem = "Name";
/*  54 */   private static CharSequence ¤¤centre = "Centre";
/*     */   
/*     */   static {
/*  57 */     D.ts(Placer.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public Placer() {
/*  62 */     final LinkedList<CLICKABLE> butts = new LinkedList();
/*  63 */     GSliderInt sl = new GSliderInt((INT.INTE)this.ii, 100, true, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  67 */           GBox b = (GBox)text;
/*  68 */           b.add((SPRITE)b.text().add(Placer.this.ii.get()).add(':').s().add((CharSequence)(Placer.this.get()).info.name()));
/*     */         }
/*     */       };
/*     */     
/*  72 */     final HovOverlay hov = new HovOverlay();
/*     */     
/*  74 */     butts.add(sl);
/*  75 */     butts.add(new GButt.ButtPanel(Dic.¤¤name)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  79 */             (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*     */                 {
/*     */                   public void acceptString(CharSequence string)
/*     */                   {
/*  83 */                     if (string != null)
/*  84 */                       (Placer.null.access$0(Placer.null.this).get()).info.name().clear().add(string); 
/*     */                   }
/*  86 */                 },  Dic.¤¤name);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  91 */             text.text((CharSequence)(Placer.this.get()).info.name());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  96 */     butts.add((new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 100 */             for (COORDINATE c : WORLD.TBOUNDS()) {
/* 101 */               if ((WORLD.REGIONS()).map.get(c) == Placer.this.get()) {
/* 102 */                 (VIEW.world()).window.centererTile.set(c);
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/* 107 */         }).hoverTitleSet(¤¤locate));
/*     */     
/* 109 */     butts.add((new GButt.ButtPanel((SPRITE)(UI.icons()).m.skull)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 113 */             for (COORDINATE c : WORLD.TBOUNDS()) {
/* 114 */               Region r = (Region)(WORLD.REGIONS()).pmap.get(c);
/* 115 */               if (r != null && r.index() == Placer.this.ii.get()) {
/* 116 */                 (WORLD.REGIONS()).pmap.set(c.x(), c.y(), (Region)null);
/*     */               }
/*     */             } 
/*     */           }
/* 120 */         }).hoverInfoSet(¤¤removeC));
/*     */     
/* 122 */     final PlacableMulti undo = new PlacableMulti(String.valueOf(¤¤remove) + ": " + String.valueOf(¤¤remove), "", (UI.icons()).m.place_ellispse.resized(32).twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0))
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 126 */           (WORLD.REGIONS()).pmap.set(tx, ty, (Region)null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 132 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 137 */           hov.hovered = null;
/* 138 */           hov.add();
/*     */         }
/*     */       };
/*     */     
/* 142 */     PlacableMulti placableMulti2 = new PlacableMulti(Dic.¤¤Region, "", (UI.icons()).m.place_ellispse.resized(32))
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 146 */           (WORLD.REGIONS()).pmap.set(tx, ty, Placer.this.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 151 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 158 */           return undo;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 163 */           return (LIST<CLICKABLE>)butts;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 168 */           hov.hovered = Placer.this.get();
/* 169 */           hov.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int oktiles, AREA a) {
/* 174 */           if (a.area() == 1)
/* 175 */             Placer.this.hover(b, a.body().x1(), a.body().y1()); 
/* 176 */           super.placeInfo(b, oktiles, a);
/*     */         }
/*     */       };
/*     */     
/* 180 */     add(placableMulti2);
/* 181 */     add(placableMulti1);
/* 182 */     PlacableSimpleTile placableSimpleTile = new PlacableSimpleTile(String.valueOf(¤¤namem) + ": " + String.valueOf(¤¤namem))
/*     */       {
/*     */         
/*     */         public void place(int tx, int ty)
/*     */         {
/* 187 */           final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 188 */           (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*     */               {
/*     */                 public void acceptString(CharSequence string)
/*     */                 {
/* 192 */                   if (string != null)
/* 193 */                     reg.info.name().clear().add(string); 
/*     */                 }
/* 195 */               },  Dic.¤¤name);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 201 */           return ((WORLD.REGIONS()).map.get(tx, ty) != null) ? null : E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfo(int tx, int ty, GBox hoverBox) {
/* 206 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 207 */           if (reg != null) {
/* 208 */             hoverBox.add((SPRITE)hoverBox.text().add(reg.index()));
/* 209 */             hoverBox.NL();
/* 210 */             hoverBox.text((CharSequence)reg.info.name());
/*     */           } 
/* 212 */           super.hoverInfo(tx, ty, hoverBox);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderOverlay(GameWindow window) {
/* 219 */           hov.hovered = (Region)(WORLD.REGIONS()).map.get((COORDINATE)window.tile());
/* 220 */           hov.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 225 */           return (SPRITE)(UI.icons()).m.menu;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 230 */     add(placableSimpleTile);
/*     */     
/* 232 */     placableSimpleTile = new PlacableSimpleTile(String.valueOf(¤¤centre) + ": " + String.valueOf(¤¤centre))
/*     */       {
/*     */         
/*     */         public void place(int tx, int ty)
/*     */         {
/* 237 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 238 */           reg.info.centreSet(tx, ty);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 244 */           if ((WORLD.REGIONS()).map.get(tx, ty) == null)
/* 245 */             return E; 
/* 246 */           return WorldCentrePlacablity.regionC(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfo(int tx, int ty, GBox hoverBox) {
/* 251 */           super.hoverInfo(tx, ty, hoverBox);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderOverlay(GameWindow window) {
/* 256 */           hov.hovered = (Region)(WORLD.REGIONS()).map.get((COORDINATE)window.tile());
/* 257 */           hov.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 262 */           return (SPRITE)(UI.icons()).m.crossair;
/*     */         }
/*     */       };
/*     */     
/* 266 */     add(placableSimpleTile);
/*     */     
/* 268 */     PlacableFixedImp placableFixedImp = new PlacableFixedImp(¤¤name, 1, 1, "", (SPRITE)(UI.icons()).m.flag)
/*     */       {
/*     */ 
/*     */         
/* 272 */         final UIWorldToolCapitolPlaceInfo info = new UIWorldToolCapitolPlaceInfo();
/*     */ 
/*     */ 
/*     */         
/*     */         public int width() {
/* 277 */           return 3;
/*     */         }
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, int rx, int ry) {
/* 282 */           if (rx == 0 && ry == 0)
/* 283 */             clear(); 
/* 284 */           (WORLD.REGIONS()).pmap.set(tx, ty, WORLD.REGIONS().getByIndex(0));
/* 285 */           if (rx == 1 && ry == 1) {
/* 286 */             (WORLD.REGIONS().getByIndex(0)).info.centreSet(tx, ty);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int height() {
/* 294 */           return 3;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 299 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 304 */           if (rx == 0 && ry == 0)
/* 305 */             return WorldCentrePlacablity.terrain(tx, ty); 
/* 306 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int x1, int y1) {
/* 311 */           this.info.placeInfo(b, x1, y1, FACTIONS.player().race());
/*     */         }
/*     */         
/*     */         public void clear() {
/* 315 */           for (COORDINATE c : WORLD.TBOUNDS()) {
/* 316 */             if ((WORLD.REGIONS()).map.get(c) == WORLD.REGIONS().getByIndex(0)) {
/* 317 */               (WORLD.REGIONS()).pmap.set(c, (Object)null);
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/*     */         public void updateRegardless(GameWindow window) {
/* 323 */           hov.hovered = null;
/* 324 */           hov.add();
/*     */         }
/*     */       };
/*     */     
/* 328 */     add(placableFixedImp);
/*     */   }
/*     */   
/*     */   private static class HovOverlay
/*     */     extends WorldOverlays.OverlayTile {
/*     */     public HovOverlay() {
/* 334 */       super(true, false);
/*     */     }
/*     */     private Region hovered;
/*     */     
/*     */     protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 339 */       Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 340 */       if (reg != null) {
/* 341 */         COLOR c = (reg == this.hovered) ? COLOR.WHITE100 : COLOR.WHITE30;
/* 342 */         c.bind();
/* 343 */         if (it.tx() == reg.cx() && it.ty() == reg.cy()) {
/* 344 */           for (DIR d : DIR.ALL) {
/* 345 */             int m = d.mask();
/* 346 */             if (!d.isOrtho())
/* 347 */               m = d.next(1).mask() | d.next(-1).mask(); 
/* 348 */             m ^= 0xFFFFFFFF;
/* 349 */             m &= 0xF;
/* 350 */             (SPRITES.cons()).BIG.outline.render(r, m, it.x() + d.x() * 64, it.y() + d.y() * 64);
/*     */           } 
/*     */         } else {
/* 353 */           int m = 0;
/* 354 */           for (DIR d : DIR.ORTHO) {
/* 355 */             if ((WORLD.REGIONS()).map.get(it.tx(), it.ty(), d) == reg)
/* 356 */               m |= d.mask(); 
/*     */           } 
/* 358 */           (SPRITES.cons()).BIG.dashed.render(r, m, it.x(), it.y());
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void hover(GBox b, int tx, int ty) {
/* 367 */     Region rr = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 368 */     if (rr != null) {
/* 369 */       b.NL();
/* 370 */       b.add((SPRITE)b.text().add(Dic.¤¤Current).add(':').s().add(rr.index()).add((CharSequence)rr.info.name()));
/* 371 */       b.NL();
/*     */     } 
/*     */   }
/*     */   
/*     */   private Region get() {
/* 376 */     return WORLD.REGIONS().getByIndex(this.ii.get());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */