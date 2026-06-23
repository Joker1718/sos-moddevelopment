/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
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
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.keyboard.KEYS;
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
/*     */ class Detail
/*     */   extends ISidePanel
/*     */ {
/*     */   private RoomInstance room;
/* 231 */   private final int detailWidth = 320;
/*     */   
/* 233 */   private final StringInputSprite panelTitle = new StringInputSprite(24, (UI.FONT()).S)
/*     */     {
/*     */       protected void change() {
/* 236 */         UIRoom.Detail.this.room.name().clear().add((CharSequence)text());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Detail(final RoomBlueprintIns<?> p, UIRoomModule... appliers) {
/* 242 */     GETTER<RoomInstance> gg = new GETTER<RoomInstance>()
/*     */       {
/*     */         public RoomInstance get()
/*     */         {
/* 246 */           return UIRoom.Detail.this.room;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 251 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 254 */           if (!UIRoom.Detail.this.room.exists()) {
/* 255 */             UIRoom.Detail.this.last().remove(UIRoom.Detail.this);
/*     */             return;
/*     */           } 
/* 258 */           if (UIRoom.Detail.this.room.blueprintI() != p) {
/* 259 */             UIRoom.Detail.this.last().remove(UIRoom.Detail.this);
/*     */             
/*     */             return;
/*     */           } 
/* 263 */           SETT.OVERLAY().add(UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY());
/* 264 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 269 */     this.section.body().setWidth(320.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     GuiSection section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 277 */           super.render(r, ds);
/* 278 */           GCOLOR.UI().border().render(r, UIRoom.Detail.this.section().body().x1() + 8, UIRoom.Detail.this.section().body().x2() - 8, body().y2() - 1, body().y2());
/*     */         }
/*     */       };
/*     */     
/* 282 */     CLICKABLE wiki = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */       {
/*     */         protected void clickA() {
/* 285 */           if (p.info.wiki != null) {
/* 286 */             p.info.wiki.exe();
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/* 291 */           activeSet((p.info.wiki != null));
/*     */         }
/* 294 */       }).hoverInfoSet(Dic.¤¤Encyclopedia);
/* 295 */     section.add((RENDEROBJ)wiki);
/*     */     
/* 297 */     CLICKABLE list = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.menu)
/*     */       {
/*     */         protected void clickA() {
/* 300 */           UIRoom.Detail.this.last().addDontRemove((VIEW.s()).ui.rooms.main(), (UIRoom.Detail.access$0(UIRoom.Detail.this)).table.get());
/* 301 */           UIRoom.Detail.this.last().add(UIRoom.Detail.this, false);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 306 */           selectedSet(UIRoom.Detail.this.last().added((UIRoom.Detail.access$0(UIRoom.Detail.this)).table.get()));
/*     */         }
/* 308 */       }).hoverInfoSet(Dic.¤¤List);
/* 309 */     section.addRightC(0, (RENDEROBJ)list);
/* 310 */     if (p.employment() != null || p == (SETT.ROOMS()).DUMP) {
/*     */       
/* 312 */       CLICKABLE cLICKABLE = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.lock)
/*     */         {
/*     */           protected void clickA() {
/* 315 */             UIRoom.Detail.this.room.activate(!UIRoom.Detail.this.room.active());
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 319 */             selectedSet(UIRoom.Detail.this.room.active());
/*     */           }
/* 321 */         }).hoverInfoSet(UIRoom.¤¤ActivateDesc);
/* 322 */       section.addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */     } 
/*     */     
/* 325 */     CLICKABLE expand = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.building)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 329 */           visableSet((UIRoom.Detail.this.room.constructor() != null && UIRoom.Detail.this.room.constructor().usesArea()));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 334 */           if (UIRoom.Detail.this.room.constructor() != null && UIRoom.Detail.this.room.constructor().usesArea()) {
/* 335 */             (VIEW.s()).ui.placer.reconstruct(UIRoom.Detail.this.room);
/*     */           }
/*     */         }
/* 338 */       }).hoverInfoSet(UIRoom.¤¤Refurnish);
/* 339 */     section.addRightC(4, (RENDEROBJ)expand);
/*     */     
/* 341 */     CLICKABLE delete = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.trash)
/*     */       {
/*     */         protected void clickA() {
/* 344 */           if (UIRoom.Detail.this.room.exists()) {
/*     */             
/* 346 */             if (UIRoom.Detail.this.room.area() == 1) {
/* 347 */               TmpArea a = UIRoom.Detail.this.room.remove(UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY(), true, this, false);
/* 348 */               if (a != null)
/* 349 */                 a.clear(); 
/*     */               return;
/*     */             } 
/* 352 */             (VIEW.inters()).yesNo.activate(UIRoom.¤¤delete, 
/* 353 */                 new ACTION()
/*     */                 {
/*     */                   public void exe()
/*     */                   {
/* 357 */                     TmpArea a = (UIRoom.Detail.null.access$0(UIRoom.Detail.null.this)).room.remove((UIRoom.Detail.null.access$0(UIRoom.Detail.null.this)).room.mX(), (UIRoom.Detail.null.access$0(UIRoom.Detail.null.this)).room.mY(), true, this, false);
/* 358 */                     if (a != null)
/* 359 */                       a.clear(); 
/*     */                   }
/* 361 */                 }new ACTION()
/*     */                 {
/*     */ 
/*     */                   
/*     */                   public void exe() {}
/*     */                 }, 
/*     */                 
/* 368 */                 true);
/*     */           } 
/*     */         }
/* 371 */       }).hoverInfoSet(Dic.¤¤delete);
/* 372 */     section.addRightC(4, (RENDEROBJ)delete);
/*     */     
/* 374 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 378 */           text.add(UIRoom.Detail.this.room.area());
/* 379 */           text.normalify2();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 384 */           b.title(Dic.¤¤Area);
/*     */           
/* 386 */           if (UIRoom.Detail.this.room.constructor() != null) {
/* 387 */             b.textLL(Dic.¤¤Resources);
/* 388 */             b.NL(2);
/* 389 */             Furnisher f = UIRoom.Detail.this.room.constructor();
/* 390 */             for (int i = 0; i < f.resources(); i++) {
/* 391 */               b.add((SPRITE)f.resource(i).icon());
/* 392 */               b.textL((f.resource(i)).name);
/* 393 */               b.tab(6);
/* 394 */               b.add((SPRITE)GFORMAT.i(b.text(), UIRoom.Detail.this.room.resAmount(i, UIRoom.Detail.this.room.upgrade())));
/* 395 */               b.NL();
/*     */             }
/*     */           
/*     */           } 
/*     */         }
/* 400 */       }).hh((SPRITE)(SPRITES.icons()).m.expand).hoverInfoSet(Dic.¤¤Area);
/* 401 */     section.add((RENDEROBJ)hOVERABLE, 0, section.body().y2() + 4);
/*     */     
/* 403 */     if (p.degrades()) {
/* 404 */       LinkedList<RENDEROBJ> ss = new LinkedList(); byte b2; int j; UIRoomModule[] arrayOfUIRoomModule1;
/* 405 */       for (j = (arrayOfUIRoomModule1 = appliers).length, b2 = 0; b2 < j; ) { UIRoomModule a = arrayOfUIRoomModule1[b2];
/* 406 */         a.appendPanelIcon((LISTE<RENDEROBJ>)ss, gg); b2++; }
/*     */       
/* 408 */       for (RENDEROBJ rr : ss) {
/* 409 */         section.addRightCAbs(78, rr);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 415 */     HOVERABLE.HoverableAbs h = new HOVERABLE.HoverableAbs(64)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 419 */           p.icon.huge.render(r, (RECTANGLE)this.body);
/*     */ 
/*     */ 
/*     */           
/* 423 */           UIRoom.errorPrep(); byte b; int i; UIRoomModule[] arrayOfUIRoomModule;
/* 424 */           for (i = (arrayOfUIRoomModule = appliers).length, b = 0; b < i; ) { UIRoomModule a = arrayOfUIRoomModule[b];
/* 425 */             a.problem(UIRoom.free, (LISTE<CharSequence>)UIRoom.errors, (LISTE<CharSequence>)UIRoom.warnings, (Room)UIRoom.Detail.this.room, UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY()); b++; }
/*     */           
/* 427 */           if (!UIRoom.errors.isEmpty() || !UIRoom.warnings.isEmpty()) {
/*     */ 
/*     */             
/* 430 */             OPACITY.O25TO100.bind();
/* 431 */             if (UIRoom.warnings.isEmpty()) {
/* 432 */               (GCOLOR.MAP()).SOSO.bind();
/*     */             } else {
/* 434 */               (GCOLOR.MAP()).BAD.bind();
/* 435 */             }  (SPRITES.icons()).m.flag.render(r, this.body.x1(), this.body.x1() + 48, this.body.y1(), this.body.y1() + 48);
/* 436 */             OPACITY.unbind();
/*     */           } 
/*     */           
/* 439 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 444 */           GBox box = (GBox)text;
/* 445 */           UIRoom.errorPrep(); byte b; int i; UIRoomModule[] arrayOfUIRoomModule;
/* 446 */           for (i = (arrayOfUIRoomModule = appliers).length, b = 0; b < i; ) { UIRoomModule a = arrayOfUIRoomModule[b];
/* 447 */             a.problem(UIRoom.free, (LISTE<CharSequence>)UIRoom.errors, (LISTE<CharSequence>)UIRoom.warnings, (Room)UIRoom.Detail.this.room, UIRoom.Detail.this.room.mX(), UIRoom.Detail.this.room.mY());
/*     */             b++; }
/*     */           
/* 450 */           for (CharSequence e : UIRoom.errors) {
/* 451 */             box.add((SPRITE)(UI.icons()).s.flag, (GCOLOR.MAP()).BAD);
/* 452 */             box.error(e);
/* 453 */             box.NL();
/*     */           } 
/* 455 */           for (CharSequence e : UIRoom.warnings) {
/* 456 */             box.add((SPRITE)(UI.icons()).s.alert, (GCOLOR.MAP()).SOSO);
/* 457 */             box.add((SPRITE)box.text().warnify().add(e));
/* 458 */             box.NL();
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 463 */     section.addRelBody(4, DIR.W, (RENDEROBJ)h);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 468 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.arrow_left)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 472 */           RoomInstance prev = UIRoom.Detail.this.room.blueprintI().getInstance(UIRoom.Detail.this.room.blueprintI().instancesSize() - 1);
/* 473 */           for (int i = 0; i < UIRoom.Detail.this.room.blueprintI().instancesSize(); i++) {
/* 474 */             RoomInstance ins = UIRoom.Detail.this.room.blueprintI().getInstance(i);
/* 475 */             if (ins == UIRoom.Detail.this.room) {
/* 476 */               UIRoom.Detail.access$0(UIRoom.Detail.this).detail(prev);
/* 477 */               (VIEW.s().getWindow()).centererTile.set(UIRoom.Detail.this.room.body().cX(), UIRoom.Detail.this.room.body().cY());
/*     */               break;
/*     */             } 
/* 480 */             prev = ins;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 486 */           if ((KEYS.MAIN()).SHRINK.consumeClick()) {
/* 487 */             clickA();
/*     */           }
/* 489 */           super.renAction();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 494 */           text.title(Dic.¤¤Previous);
/* 495 */           text.text((KEYS.MAIN()).SHRINK.repr());
/*     */         }
/*     */       };
/*     */     
/* 499 */     section.addRelBody(4, DIR.W, (RENDEROBJ)b);
/* 500 */     b = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.arrow_right)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 504 */           for (int i = 0; i < UIRoom.Detail.this.room.blueprintI().instancesSize(); i++) {
/* 505 */             RoomInstance ins = UIRoom.Detail.this.room.blueprintI().getInstance(i);
/* 506 */             if (ins == UIRoom.Detail.this.room) {
/* 507 */               UIRoom.Detail.this.room = UIRoom.Detail.this.room.blueprintI().getInstance((i + 1) % UIRoom.Detail.this.room.blueprintI().instancesSize());
/* 508 */               UIRoom.Detail.access$0(UIRoom.Detail.this).detail(UIRoom.Detail.this.room);
/* 509 */               (VIEW.s().getWindow()).centererTile.set(UIRoom.Detail.this.room.body().cX(), UIRoom.Detail.this.room.body().cY());
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 517 */           if ((KEYS.MAIN()).GROW.consumeClick()) {
/* 518 */             clickA();
/*     */           }
/* 520 */           super.renAction();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 525 */           text.title(Dic.¤¤Next);
/* 526 */           text.text((KEYS.MAIN()).GROW.repr());
/*     */         }
/*     */       };
/*     */     
/* 530 */     section.addRelBody(4, DIR.E, (RENDEROBJ)b);
/* 531 */     section.addRelBody(2, DIR.N, (RENDEROBJ)new GInput(this.panelTitle));
/*     */     
/* 533 */     section.body().moveCX(this.section.body().cX());
/* 534 */     section.body().moveY1(this.section.body().y1());
/* 535 */     section.body().incrH(8.0D);
/* 536 */     this.section.add((RENDEROBJ)section);
/*     */     
/*     */     byte b1;
/*     */     
/*     */     int i;
/*     */     
/*     */     UIRoomModule[] arrayOfUIRoomModule;
/* 543 */     for (i = (arrayOfUIRoomModule = appliers).length, b1 = 0; b1 < i; ) { UIRoomModule a = arrayOfUIRoomModule[b1];
/* 544 */       a.appendPanel(this.section, gg, 0, this.section.getLastY2() + 10);
/*     */       b1++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoom$Detail.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */