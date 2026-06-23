/*     */ package settlement.tilemap.ground;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ class Debug
/*     */ {
/*     */   Debug(final Ground g) {
/*  29 */     final LinkedList<CLICKABLE> bs = new LinkedList();
/*  30 */     final GETTER.GETTER_IMP<GroundType> get = new GETTER.GETTER_IMP(g.types.NORMAL); byte b; int i;
/*     */     GroundType[] arrayOfGroundType;
/*  32 */     for (i = (arrayOfGroundType = g.types.ALL).length, b = 0; b < i; ) { final GroundType t = arrayOfGroundType[b];
/*  33 */       GButt gButt = (new GButt.ButtPanel(t.icon)
/*     */         {
/*     */           protected void clickA() {
/*  36 */             get.set(t);
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*  40 */             selectedSet((get.get() == t));
/*     */           }
/*  42 */         }).hoverSet(t);
/*  43 */       bs.add(gButt);
/*     */       b++; }
/*     */     
/*  46 */     PlacableMulti p = new PlacableMulti("GROUND: Types")
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  50 */           g.MAP.set(tx, ty, get.get());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  56 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/*  61 */           return (LIST<CLICKABLE>)bs;
/*     */         }
/*     */       };
/*     */     
/*  65 */     IDebugPanelSett.add((PLACABLE)p);
/*     */     
/*  67 */     final PlacableMulti undo = new PlacableMulti("GROUND: Moisture down")
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  71 */           g.MOISTURE_CURRENT.increment(tx, ty, -0.06666666666666667D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  77 */           return null;
/*     */         }
/*     */       };
/*     */     
/*  81 */     p = new PlacableMulti("GROUND: Moisture")
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/*  85 */           g.MOISTURE_CURRENT.increment(tx, ty, 0.06666666666666667D);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  90 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/*  95 */           return (PLACABLE)undo;
/*     */         }
/*     */       };
/*  98 */     IDebugPanelSett.add((PLACABLE)p);
/*     */     
/* 100 */     IDebugPanelSett.add("GROUND: set color", new ACTION() {
/* 101 */           int i = 0;
/*     */ 
/*     */           
/*     */           public void exe() {
/* 105 */             this.i++;
/* 106 */             this.i %= CLIMATES.ALL().size();
/* 107 */             COLOR wet = ((CLIMATE)CLIMATES.ALL().get(this.i)).colorGroundWet;
/* 108 */             COLOR dry = ((CLIMATE)CLIMATES.ALL().get(this.i)).colorGroundDry;
/* 109 */             LOG.ln(Integer.valueOf(this.i));
/* 110 */             g.setColors(dry, wet, 0.0D);
/*     */           }
/*     */         });
/*     */     
/* 114 */     IDebugPanelSett.add("GROUND: set color", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 118 */             (VIEW.s()).panels.add(new Debug.DebugCol(), true);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static class DebugCol
/*     */     extends ISidePanel
/*     */   {
/* 126 */     private final ColorImp dry = new ColorImp(COLOR.WHITE50);
/* 127 */     private final ColorImp wet = new ColorImp(COLOR.WHITE50);
/*     */     
/*     */     DebugCol() {
/* 130 */       titleSet("ground color");
/* 131 */       this.dry.set((COLOR)(SETT.GROUND()).dry);
/* 132 */       this.wet.set((COLOR)(SETT.GROUND()).wet);
/* 133 */       this.section.addDown(2, (RENDEROBJ)new GColorPicker(false, "dry")
/*     */           {
/*     */             public ColorImp color()
/*     */             {
/* 137 */               return Debug.DebugCol.this.dry;
/*     */             }
/*     */ 
/*     */             
/*     */             public void change() {
/* 142 */               SETT.GROUND().setColors((COLOR)Debug.DebugCol.this.dry, (COLOR)Debug.DebugCol.this.wet, 0.0D);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 147 */       this.section.addDown(2, (RENDEROBJ)new GColorPicker(false, "wet")
/*     */           {
/*     */             public ColorImp color()
/*     */             {
/* 151 */               return Debug.DebugCol.this.wet;
/*     */             }
/*     */ 
/*     */             
/*     */             public void change() {
/* 156 */               SETT.GROUND().setColors((COLOR)Debug.DebugCol.this.dry, (COLOR)Debug.DebugCol.this.wet, 0.0D);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Debug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */