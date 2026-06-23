/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.infra.logistics.MoveOrderPullUI;
/*     */ import settlement.room.infra.logistics.MoveOrderPullersUI;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRes;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<HaulerInstance, ROOM_HAULER>
/*     */ {
/*     */   Gui(ROOM_HAULER s) {
/*  47 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(final GuiSection section, GGrid grid, final GETTER<HaulerInstance> g, int x1, int y1) {
/*  55 */     GuiSection s = new GuiSection();
/*  56 */     int i = 0;
/*     */ 
/*     */     
/*  59 */     for (HaulerTally.TallyData d : ((ROOM_HAULER)this.blueprint).tally.datas) {
/*  60 */       s.addGridD((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  64 */               GFORMAT.i(text, d.get((HaulerInstance)g.get()));
/*     */             }
/*  67 */           }).hv(d.name), i++, 2, 160, 32, DIR.N);
/*     */     } 
/*  69 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     s = new GuiSection();
/*     */ 
/*     */     
/*  77 */     GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.wheel)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  81 */           selectedSet(((HaulerInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  86 */           ((HaulerInstance)g.get()).fetchingSet(!((HaulerInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  93 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  94 */           if (((HaulerInstance)g.get()).fetching() && ((HaulerInstance)g.get()).coolFetch > -1) {
/*  95 */             (GCOLOR.UI()).SOSO.hovered.bind();
/*  96 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/*  97 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 103 */           GBox b = (GBox)text;
/* 104 */           b.title(MoveDic.¤¤fetch);
/* 105 */           b.text(MoveDic.¤¤fetchD);
/* 106 */           b.NL();
/* 107 */           if (((HaulerInstance)g.get()).fetching() && ((HaulerInstance)g.get()).coolFetch > -1) {
/* 108 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           }
/* 110 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 115 */     p.body.setDim(48.0D);
/* 116 */     s.addRightC(0, (RENDEROBJ)p);
/*     */     
/* 118 */     p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.priority)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 122 */           selectedSet(((HaulerInstance)g.get()).prio());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 127 */           ((HaulerInstance)g.get()).prioSet();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 134 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 135 */           if (((HaulerInstance)g.get()).prio() && ((HaulerInstance)g.get()).coolFetch > -1) {
/* 136 */             (GCOLOR.UI()).SOSO.hovered.bind();
/* 137 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 138 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 144 */           GBox b = (GBox)text;
/* 145 */           b.title(MoveDic.¤¤prio);
/* 146 */           b.text(MoveDic.¤¤prioD);
/* 147 */           b.NL();
/* 148 */           if (((HaulerInstance)g.get()).prio() && ((HaulerInstance)g.get()).coolFetch > -1) {
/* 149 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 156 */     p.body.setDim(48.0D);
/* 157 */     s.addRightC(0, (RENDEROBJ)p);
/*     */ 
/*     */ 
/*     */     
/* 161 */     MoveOrderPullUI ui = new MoveOrderPullUI(g, g, null, 2);
/* 162 */     s.addRightC(8, (RENDEROBJ)ui);
/* 163 */     s.addRightC(0, (RENDEROBJ)new MoveOrderPullersUI(g));
/*     */ 
/*     */ 
/*     */     
/* 167 */     GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)(UI.icons()).m.lock)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 171 */           selectedSet(((HaulerInstance)g.get()).storing());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 176 */           ((HaulerInstance)g.get()).storingSet(!((HaulerInstance)g.get()).storing());
/*     */         }
/*     */       };
/*     */     
/* 180 */     buttPanel1.hoverTitleSet(MoveDic.¤¤storing);
/* 181 */     buttPanel1.hoverInfoSet(MoveDic.¤¤storingD);
/* 182 */     buttPanel1.body.setDim(48.0D);
/* 183 */     s.addRightC(8, (RENDEROBJ)buttPanel1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     section.addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */     
/* 192 */     section.addRelBody(4, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(1, 8)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 196 */             GCOLOR.UI().border().render(r, section.body().x1() + 8, section.body().x2() - 8, this.body.y1() + 4, this.body.y1() + 5);
/*     */           }
/*     */         });
/*     */     
/* 200 */     section.addRelBody(8, DIR.S, (RENDEROBJ)new UIPickerRes(true)
/*     */         {
/*     */           protected void select(RESOURCE r, int li)
/*     */           {
/* 204 */             ((HaulerInstance)g.get()).setResource(r);
/*     */           }
/*     */ 
/*     */           
/*     */           protected RESOURCE getResource() {
/* 209 */             return ((HaulerInstance)g.get()).resource();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableButt(GuiSection s, final GETTER<RoomInstance> ins) {
/* 218 */     s.add((SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 222 */             HaulerInstance in = (HaulerInstance)ins.get();
/* 223 */             RESOURCE res = in.resource();
/* 224 */             Icon icon = (res == null) ? (UI.icons()).m.cancel : res.icon();
/* 225 */             icon.render(r, X1, X2, Y1, Y2);
/*     */           }
/* 227 */         }0, s.body().y2());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid icons, GGrid text, GuiSection sExtra) {
/* 233 */     for (HaulerTally.TallyData d : ((ROOM_HAULER)this.blueprint).tally.datas) {
/* 234 */       text.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 238 */               GFORMAT.i(text, d.total((RESOURCE)null));
/*     */             }
/* 241 */           }).hh(d.name));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(HaulerInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 249 */     if (i.employees().target() == 0)
/*     */       return; 
/* 251 */     boolean ok = false;
/* 252 */     boolean has = false; byte b; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 253 */     for (j = (arrayOfMoveOrderPull = i.moveOrdersPull()).length, b = 0; b < j; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 254 */       if (o != null) {
/* 255 */         has = true;
/* 256 */         CharSequence p = o.problem(i);
/* 257 */         if (p != null) {
/* 258 */           errors.add(p); break;
/*     */         } 
/* 260 */         if (o.cooldown >= -1)
/* 261 */           ok = true; 
/*     */       } 
/*     */       b++; }
/*     */     
/* 265 */     if (i.fetching() && i.coolFetch > -1 && i.coolOrganize > -1 && has && !ok) {
/* 266 */       errors.add(MoveDic.¤¤pullProblem);
/*     */     }
/*     */     
/* 269 */     super.problem(i, free, errors, warnings);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, HaulerInstance i) {
/* 274 */     super.hover(box, i);
/* 275 */     box.sep();
/* 276 */     if (i.fetching() && i.employees().target() > 0) {
/* 277 */       box.textL(MoveDic.¤¤fetching);
/* 278 */       box.NL();
/* 279 */       if (i.coolFetch > -1) {
/* 280 */         box.add((SPRITE)box.text().warnify().add(MoveDic.¤¤fetchProblem));
/* 281 */         box.NL();
/*     */       }  byte b; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 283 */       for (j = (arrayOfMoveOrderPull = i.moveOrdersPull()).length, b = 0; b < j; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 284 */         if (o != null) {
/* 285 */           CharSequence p = o.warning(i);
/* 286 */           if (p != null) {
/* 287 */             box.add((SPRITE)box.text().warnify().add(p));
/* 288 */             box.NL();
/*     */           } 
/*     */         }  b++; }
/*     */     
/*     */     } 
/* 293 */     if (i.storing()) {
/* 294 */       box.add((SPRITE)box.text().warnify().add(MoveDic.¤¤storing));
/*     */     }
/* 296 */     box.NL(8);
/*     */     
/* 298 */     if (i.resource() != null) {
/* 299 */       box.add((SPRITE)i.resource().icon());
/* 300 */       box.NL();
/* 301 */       for (HaulerTally.TallyData d : ((ROOM_HAULER)this.blueprint).tally.datas) {
/* 302 */         box.textLL(d.name);
/* 303 */         box.tab(7);
/* 304 */         box.add((SPRITE)GFORMAT.i(box.text(), d.get(i)));
/* 305 */         box.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 316 */     super.appendTableFilters(filters, sorts, appliers);
/*     */     
/* 318 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 319 */       filters.add(new GTableSorter.GTFilter<RoomInstance>(res.names)
/*     */           {
/*     */             public boolean passes(RoomInstance h)
/*     */             {
/* 323 */               HaulerInstance i = (HaulerInstance)h;
/* 324 */               if (i.resource() == res)
/* 325 */                 return true; 
/* 326 */               return false;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */