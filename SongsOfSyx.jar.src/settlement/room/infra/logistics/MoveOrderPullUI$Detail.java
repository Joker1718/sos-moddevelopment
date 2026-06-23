/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Detail
/*     */ {
/*     */   private MoveOrderPull o;
/* 232 */   private final GuiSection section = new GuiSection();
/*     */   
/*     */   private int oi;
/*     */   
/*     */   Detail(final MoveOrderPullUI.Placer placer, LIST<RESOURCE> resources) {
/* 237 */     this.section.add((RENDEROBJ)(new HOVERABLE.Sprite(placer.getIcon())).hoverInfoSet(placer.name()), 0, this.section.body().y2() + 4);
/* 238 */     this.section.addRightCAbs(48, (RENDEROBJ)new CLICKABLE.ClickableAbs(200, 32)
/*     */         {
/* 240 */           final GText t = new GText((UI.FONT()).S, 24);
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 244 */             GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 245 */             this.t.setMaxWidth(180);
/* 246 */             this.t.setMultipleLines(false);
/* 247 */             this.t.clear();
/* 248 */             this.t.normalify();
/* 249 */             if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 250 */               this.t.add(MoveOrderPullUI.¤¤notSet);
/* 251 */               this.t.errorify();
/*     */             } else {
/* 253 */               this.t.add((CharSequence)MoveOrderPullUI.Detail.this.o.sourceI().name());
/*     */             } 
/* 255 */             this.t.adjustWidth();
/* 256 */             this.t.renderC(r, (RECTANGLE)this.body);
/* 257 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 258 */             if ((((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()).length >= MoveOrderPullUI.Detail.this.oi)
/*     */               return; 
/* 260 */             if (isHovered && ((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source() != null) {
/* 261 */               RoomInstance ins = (RoomInstance)((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source();
/* 262 */               SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 268 */             text.title(placer.name());
/* 269 */             if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 270 */               text.text(MoveOrderPullUI.¤¤notSetC);
/*     */             } else {
/* 272 */               text.text(MoveOrderPullUI.¤¤setC);
/*     */             } 
/* 274 */             super.hoverInfoGet(text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 279 */             if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 280 */               placer.activate(MoveOrderPullUI.Detail.this.oi);
/*     */             } else {
/* 282 */               (VIEW.s().getWindow()).centererTile.set(MoveOrderPullUI.Detail.this.o.sourceI().body().cX(), MoveOrderPullUI.Detail.this.o.sourceI().body().cY());
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 289 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(300, 64) {
/* 290 */         GText t = new GText((UI.FONT()).S, 128);
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 294 */           this.t.clear();
/* 295 */           this.t.setMultipleLines(true);
/* 296 */           this.t.setMaxWidth(280);
/* 297 */           if (MoveOrderPullUI.Detail.this.o.problem((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()) != null) {
/* 298 */             this.t.add(MoveOrderPullUI.Detail.this.o.problem((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()));
/* 299 */             this.t.errorify();
/* 300 */           } else if (MoveOrderPullUI.Detail.this.o.warning((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()) != null) {
/* 301 */             this.t.add(MoveOrderPullUI.Detail.this.o.warning((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()));
/* 302 */             this.t.warnify();
/*     */           } 
/* 304 */           this.t.adjustWidth();
/* 305 */           this.t.render(r, this.body.x1(), this.body.y1());
/*     */         }
/*     */       };
/* 308 */     this.section.add((RENDEROBJ)renderImp, 0, this.section.body().y2() + 4);
/*     */ 
/*     */     
/* 311 */     if (resources != null) {
/* 312 */       int i = 0;
/* 313 */       int rows = 8;
/* 314 */       GuiSection s = new GuiSection();
/*     */       
/* 316 */       s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.ok)
/*     */           {
/*     */             protected void clickA() {
/* 319 */               MoveOrderPullUI.Detail.this.o.resbits.or(RBIT.ALL);
/*     */             }
/* 322 */           }i++, rows, 0, 0);
/*     */       
/* 324 */       s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 328 */               MoveOrderPullUI.Detail.this.o.resbits.clear();
/*     */             }
/* 331 */           }i++, rows, 0, 0);
/*     */       
/* 333 */       for (RESOURCE r : resources) {
/*     */         
/* 335 */         s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)r.icon())
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 339 */                 selectedSet(MoveOrderPullUI.Detail.this.o.resbits.has(r));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 344 */                 MoveOrderPullUI.Detail.this.o.resbits.toggle(r);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               protected void render(SPRITE_RENDERER re, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 350 */                 super.render(re, ds, isActive, isSelected, isHovered);
/* 351 */                 if (MoveOrderPullUI.Detail.this.o.source() == null || !MoveOrderPullUI.Detail.this.o.source().moveCapacity().has(r.bit) || !((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrderPullAccepted().has(r.bit)) {
/* 352 */                   OPACITY.O50.bind();
/* 353 */                   COLOR.BLACK.render(re, (RECTANGLE)this.body, -4);
/* 354 */                   OPACITY.unbind();
/*     */                 }
/*     */               
/*     */               }
/* 358 */             }i++, rows, 0, 0);
/*     */       } 
/*     */       
/* 361 */       this.section.addRelBody(32, DIR.E, (RENDEROBJ)s);
/*     */     } 
/*     */     
/* 364 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 368 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 373 */           return 100;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 378 */           return MoveOrderPullUI.Detail.this.o.pullLimit;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 383 */           MoveOrderPullUI.Detail.this.o.pullLimit = (byte)t;
/*     */         }
/*     */       };
/*     */     
/* 387 */     GSliderInt sl = new GSliderInt(ii, 160, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 391 */           GBox b = (GBox)text;
/* 392 */           b.title(MoveOrderPullUI.¤¤Limit);
/* 393 */           b.text(MoveOrderPullUI.¤¤LimitD);
/*     */ 
/*     */           
/* 396 */           b.NL();
/* 397 */           b.add((SPRITE)GFORMAT.perc(b.text(), MoveOrderPullUI.Detail.this.o.pullLimit / 100.0D));
/* 398 */           b.NL();
/*     */           
/* 400 */           if (MoveOrderPullUI.Detail.this.o.source() != null) {
/* 401 */             for (RESOURCE res : RESOURCES.ALL()) {
/* 402 */               if (MoveOrderPullUI.Detail.this.o.source().moveCapacity().has(res) && MoveOrderPullUI.Detail.this.o.resbits.has(res)) {
/* 403 */                 int am = MoveOrderPullUI.Detail.this.o.source().moveCapacityAm(res);
/* 404 */                 b.add((SPRITE)res.icon());
/* 405 */                 b.add((SPRITE)GFORMAT.i(b.text(), (long)((MoveOrderPullUI.Detail.this.o.pullLimit * am) / 100.0D)));
/* 406 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 414 */     sl.addRelBody(8, DIR.W, (RENDEROBJ)new GHeader(MoveOrderPullUI.¤¤Limit));
/*     */     
/* 416 */     this.section.addRelBody(6, DIR.S, (RENDEROBJ)sl);
/*     */ 
/*     */     
/* 419 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤remove)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 423 */             ((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi] = null;
/* 424 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection get(int oi) {
/* 431 */     this.oi = oi;
/* 432 */     this.o = ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[oi];
/* 433 */     return this.section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI$Detail.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */