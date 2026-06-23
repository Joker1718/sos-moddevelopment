/*     */ package world.map.landmark;
/*     */ 
/*     */ import init.sprite.UI.UI;
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
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placers
/*     */   extends ArrayListGrower<PLACABLE>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final WorldLandmarks ll;
/*  34 */   private final INT.IntImp ii = new INT.IntImp(1, 255);
/*     */ 
/*     */ 
/*     */   
/*     */   Placers(final WorldLandmarks ll, final PlacerOverlay overlay) {
/*  39 */     this.ll = ll;
/*     */     
/*  41 */     final LinkedList<CLICKABLE> butts = new LinkedList();
/*  42 */     GSliderInt sl = new GSliderInt((INT.INTE)this.ii, 100, true, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  46 */           super.hoverInfoGet(text);
/*  47 */           GBox b = (GBox)text;
/*  48 */           b.add((SPRITE)b.text().add(':').add((CharSequence)(Placers.this.get()).name));
/*     */         }
/*     */       };
/*     */     
/*  52 */     butts.add(sl);
/*  53 */     butts.add(new GButt.ButtPanel(Dic.¤¤name)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  57 */             (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*     */                 {
/*     */                   public void acceptString(CharSequence string)
/*     */                   {
/*  61 */                     if (string != null)
/*  62 */                       (Placers.null.access$0(Placers.null.this).get()).name.clear().add(string); 
/*     */                   }
/*  64 */                 },  Dic.¤¤name);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  69 */             text.text((CharSequence)(Placers.this.get()).name);
/*     */           }
/*     */         });
/*     */     
/*  73 */     butts.add(new GButt.ButtPanel("...")
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  77 */             (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*     */                 {
/*     */                   public void acceptString(CharSequence string)
/*     */                   {
/*  81 */                     if (string != null)
/*  82 */                       (Placers.null.access$0(Placers.null.this).get()).description.clear().add(string); 
/*     */                   }
/*  84 */                 },  "description");
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  89 */             text.text((CharSequence)(ll.getByIndex(Placers.this.ii.get())).description);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  94 */     butts.add(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  98 */             for (COORDINATE c : WORLD.TBOUNDS()) {
/*  99 */               if (ll.setter.get(c) != null && ((WorldLandmark)ll.setter.get(c)).index() == Placers.this.ii.get()) {
/* 100 */                 (VIEW.world()).window.centererTile.set(c);
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 108 */             text.title("find landmark");
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 113 */     butts.add(new GButt.ButtPanel((SPRITE)(UI.icons()).m.skull)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 117 */             for (COORDINATE c : WORLD.TBOUNDS()) {
/* 118 */               if (ll.setter.get(c) != null && ((WorldLandmark)ll.setter.get(c)).index() == Placers.this.ii.get()) {
/* 119 */                 ll.setter.set(c, null);
/*     */               }
/*     */             } 
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 125 */             text.title("remove whole landmark");
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 130 */     final PlacableMulti undo = new PlacableMulti(String.valueOf(Dic.¤¤remove) + ": " + String.valueOf(Dic.¤¤remove), "", (UI.icons()).m.place_ellispse.resized(32).twin((SPRITE)(UI.icons()).m.anti, DIR.C, 0))
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 134 */           ll.setter.set(tx, ty, null);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 139 */           return (Placers.this.get() != null) ? null : E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 144 */           overlay.hovered = Placers.this.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int oktiles, AREA a) {
/* 149 */           Placers.this.hover(b, oktiles, a);
/*     */         }
/*     */       };
/*     */     
/* 153 */     PlacableMulti placableMulti2 = new PlacableMulti(ll.name, "", (UI.icons()).m.place_ellispse.resized(32))
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 157 */           ll.setter.set(tx, ty, Placers.this.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 162 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 169 */           return undo;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 174 */           return (LIST<CLICKABLE>)butts;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 179 */           overlay.hovered = Placers.this.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int oktiles, AREA a) {
/* 184 */           Placers.this.hover(b, oktiles, a);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 190 */     add(placableMulti2);
/* 191 */     add(placableMulti1);
/*     */   }
/*     */   
/*     */   private void hover(GBox b, int oktiles, AREA a) {
/* 195 */     if (a.area() == 1) {
/* 196 */       for (COORDINATE c : a.body()) {
/* 197 */         WorldLandmark m = (WorldLandmark)this.ll.setter.get(c);
/* 198 */         if (m != null) {
/* 199 */           b.NL();
/* 200 */           b.add((SPRITE)b.text().add(Dic.¤¤Current).add(':').s().add(m.index()).s().add((CharSequence)m.name));
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private WorldLandmark get() {
/* 210 */     return this.ll.getByIndex(this.ii.get());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\Placers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */