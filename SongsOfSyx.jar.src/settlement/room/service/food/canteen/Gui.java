/*     */ package settlement.room.service.food.canteen;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.settings.S;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<CanteenInstance, ROOM_CANTEEN> {
/*  23 */   private final CharSequence ¤¤Food = "¤Meals";
/*     */   
/*     */   Gui(ROOM_CANTEEN s) {
/*  26 */     super(s);
/*  27 */     D.t(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<CanteenInstance> g, int x1, int y1) {
/*  33 */     GuiSection s = new GuiSection();
/*  34 */     int i = 0;
/*  35 */     for (ResG e : RESOURCES.EDI().all()) {
/*     */       
/*  37 */       GButt.BSection ss = new GButt.BSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/*  41 */             GBox b = (GBox)text;
/*  42 */             b.title(e.resource.name);
/*  43 */             b.textLL(Gui.this.¤¤Food).add((SPRITE)GFORMAT.i(b.text(), ((CanteenInstance)g.get()).amount(e)));
/*  44 */             if ((S.get()).developer) {
/*  45 */               b.NL();
/*  46 */               b.textL(Dic.¤¤Access);
/*  47 */               b.add((SPRITE)GFORMAT.i(b.text(), ((CanteenInstance)g.get()).amountReserved(e)));
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  53 */             selectedSet(((CanteenInstance)g.get()).uses(e));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  58 */             ((CanteenInstance)g.get()).usesToggle(e);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/*  63 */       ss.addRightC(4, (SPRITE)e.resource.icon());
/*     */       
/*  65 */       ss.addRightC(4, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  69 */               GFORMAT.i(text, ((CanteenInstance)g.get()).amount(e));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/*  74 */       ss.body().incrW(48.0D);
/*  75 */       ss.pad(4);
/*     */       
/*  77 */       s.add((RENDEROBJ)ss, i % 3 * ss.body().width(), i / 3 * ss.body().height());
/*  78 */       i++;
/*     */     } 
/*     */ 
/*     */     
/*  82 */     s.addRelBody(2, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  86 */             GFORMAT.iofk(text, ((CanteenInstance)g.get()).amountTotal(), (((CanteenInstance)g.get()).maxAmount * RESOURCES.EDI().all().size()));
/*     */           }
/*  89 */         }).hh(this.¤¤Food));
/*     */     
/*  91 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox b, CanteenInstance i) {
/*  97 */     b.NL();
/*  98 */     b.textLL(this.¤¤Food).add((SPRITE)GFORMAT.i(b.text(), i.amountTotal()));
/*  99 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid gg, GGrid text, GuiSection sExtra) {
/* 104 */     GuiSection s = new GuiSection();
/* 105 */     int i = 0;
/* 106 */     for (ResG e : RESOURCES.EDI().all()) {
/* 107 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 111 */             GFORMAT.i(text, ((ROOM_CANTEEN)Gui.this.blueprint).amount(e));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 116 */             b.title(e.resource.name);
/* 117 */             b.textLL(Gui.this.¤¤Food).add((SPRITE)GFORMAT.i(b.text(), ((ROOM_CANTEEN)Gui.this.blueprint).amount(e)));
/*     */           }
/* 119 */         }).hv((SPRITE)e.resource.icon());
/*     */       
/* 121 */       s.add((RENDEROBJ)hOVERABLE, i % 4 * 42, i / 4 * 48);
/* 122 */       i++;
/*     */     } 
/*     */ 
/*     */     
/* 126 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 130 */             GFORMAT.i(text, ((ROOM_CANTEEN)Gui.this.blueprint).total);
/*     */           }
/* 133 */         }).hh(this.¤¤Food), 0, s.body().y1() - 16);
/*     */     
/* 135 */     text.add((RENDEROBJ)s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */