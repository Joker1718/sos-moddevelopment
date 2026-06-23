/*     */ package settlement.room.law.prison;
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<PrisonInstance, ROOM_PRISON> {
/*  46 */   private static CharSequence ¤¤Food = "¤Food To Fetch";
/*  47 */   private static CharSequence ¤¤setAll = "¤Sentence all prisoners to be: {0}";
/*  48 */   private static CharSequence ¤¤setSure = "¤Are you sure you wish to inflict the punishment: {0} on all prisoners?";
/*     */   
/*  50 */   private static CharSequence ¤¤mWTitle = "Security low";
/*  51 */   private static CharSequence ¤¤mWBody = "Since our prisons are poorly staffed or poorly supplied with food, we are running the risk of having incidents occur. Make sure they are fully staffed and have access to food.";
/*  52 */   private static CharSequence ¤¤mTitle = "Prisoner Escape!";
/*  53 */   private static CharSequence ¤¤mBody = "Since our prison was poorly staffed and tended, the prisoners have escaped!";
/*  54 */   private static CharSequence ¤¤emp = "¤Insufficient employees or lack of food might cause incidents. Full employment is required.";
/*  55 */   private static CharSequence ¤¤cancel = "Cancel all manually assigned punishments, and let the prisoners be punished according to your law settings."; private final ArrayListResize<Humanoid> list; private int upI;
/*     */   
/*     */   static {
/*  58 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_PRISON s) {
/*  62 */     super(s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     this.list = new ArrayListResize(164, 2048);
/* 273 */     this.upI = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void problem(PrisonInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 278 */     if (i.riotChance < 1.0F && (i.employees().employed() < i.employees().max() || !i.jobs.resNotFound.isClear()))
/*     */     {
/* 280 */       errors.add(¤¤emp);
/*     */     }
/*     */     
/* 283 */     super.problem(i, free, errors, warnings); } protected void appendPanel(GuiSection section, GGrid grid, final GETTER<PrisonInstance> g, int x1, int y1) { GuiSection s = new GuiSection(); int i = 0; for (ResG e : RESOURCES.EDI().all()) { GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)e.resource.icon()) { protected void renAction() { selectedSet(((PrisonInstance)g.get()).fetch.has(e.resource)); } protected void clickA() { ((PrisonInstance)g.get()).fetch.toggle(e.resource); ((PrisonInstance)g.get()).jobs.resNotFound.clear(); } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(e.resource.names); b.textLL(Dic.¤¤Consumed).add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)((ROOM_PRISON)Gui.this.blueprint).indu.ins().get(e.index())).year.get(g.get()))); } }
/*     */         ; buttPanel1.pad(4, 4); s.add((RENDEROBJ)buttPanel1, i % 4 * buttPanel1.body().width(), i / 4 * buttPanel1.body().height()); i++; }  s.addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(¤¤Food)); s.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.iofk(text, ((PrisonInstance)g.get()).prisoners(), ((PrisonInstance)g.get()).prisonersMax()); } }
/*     */         ).hh(Dic.¤¤Capacity)); section.addRelBody(8, DIR.S, (RENDEROBJ)s); GuiSection ss = new GuiSection(); int gi = 0; GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel) { protected void clickA() { Gui.this.makePrisoners((PrisonInstance)g.get()); for (Humanoid h : Gui.this.list) { if ((AIModule_Prisoner.DATA()).punishmentSet.get(h.ai()) != null) { (AIModule_Prisoner.DATA()).punishmentSet.set(h.ai(), null); h.interrupt(); }  }  } protected void renAction() { boolean a = false; Gui.this.makePrisoners((PrisonInstance)g.get()); for (Humanoid h : Gui.this.list) { if ((AIModule_Prisoner.DATA()).punishmentSet.get(h.ai()) != null) { a = true; break; }  }  activeSet(a); } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.text(Gui.¤¤cancel); } }
/*     */       ; buttPanel.setDim(40, 40); ss.addGrid((RENDEROBJ)buttPanel, gi++, 6, 2, 2); for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) { GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)p.icon, p) { ACTION a = new ACTION() { public void exe() { Gui.null.access$0(Gui.null.this).makePrisoners((PrisonInstance)g.get()); for (Humanoid h : (Gui.null.access$0(Gui.null.this)).list) { if (p.available(AIModule_Prisoner.DATA().clas(h.indu()))) { (AIModule_Prisoner.DATA()).punishmentSet.set(h.ai(), p); h.interrupt(); }  }  } }; protected void clickA() { (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP.clear().add(Gui.¤¤setSure).insert(0, p.action), this.a, ACTION.NOP, true); } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; GText t = b.text(); t.add(Gui.¤¤setAll).insert(0, p.action); b.add((SPRITE)t); } }
/* 287 */         ; buttPanel1.setDim(40, 40); ss.addGrid((RENDEROBJ)buttPanel1, gi++, 6, 2, 2); }  section.addRelBody(8, DIR.S, (RENDEROBJ)ss); GTableBuilder b = new GTableBuilder() { public int nrOFEntries() { Gui.this.makePrisoners((PrisonInstance)g.get()); return Gui.this.list.size(); } }; b.column(null, 280, new GTableBuilder.GRowBuilder() { public RENDEROBJ build(final GETTER<Integer> ier) { return (RENDEROBJ)new CLICKABLE.ClickableAbs(280, 54) { public void hoverInfoGet(GUI_BOX text) { int k = ((Integer)ier.get()).intValue(); if (k >= (Gui.null.access$0(Gui.null.this)).list.size()) return;  Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k); h.hover((GBox)text); } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1); GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -2); int k = ((Integer)ier.get()).intValue(); if (k >= (Gui.null.access$0(Gui.null.this)).list.size()) return;  Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k); int x1 = body().x1(); STATS.APPEARANCE().portraitRender(r, h.indu(), body().x1(), body().y1(), 1); Str t = Str.TMP; t.clear(); t.add(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(h.indu())).name); (GCOLOR.T()).H1.bind(); (UI.FONT()).M.render(r, (CharSequence)t, x1 + 50, body().y1() + 8); t.clear(); t.add((AIModule_Prisoner.punishment(h, h.ai())).action); (GCOLOR.T()).H2.bind(); (UI.FONT()).S.render(r, (CharSequence)t, x1 + 50, body().y1() + 32); } protected void clickA() { int k = ((Integer)ier.get()).intValue(); if (k >= (Gui.null.access$0(Gui.null.this)).list.size()) return;  Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k); h.click(); } }; } }); int he = ISidePanel.HEIGHT - section.body().height() - 16; section.addRelBody(8, DIR.S, (RENDEROBJ)b.createHeight(he, false)); } private void makePrisoners(PrisonInstance ins) { if (this.upI == GAME.updateI())
/*     */       return; 
/* 289 */     this.list.clearSoft();
/* 290 */     if (ins == null)
/*     */       return;  byte b; int i; ENTITY[] arrayOfENTITY;
/* 292 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 293 */       if (e instanceof Humanoid) {
/* 294 */         Humanoid a = (Humanoid)e;
/* 295 */         if (AIModule_Prisoner.isPrisoner(a, ins))
/* 296 */           this.list.add(a); 
/*     */       } 
/*     */       b++; }
/*     */     
/* 300 */     this.upI = GAME.updateI(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 306 */     GuiSection s = new GuiSection();
/* 307 */     final GChart cc = new GChart();
/* 308 */     int i = 0;
/* 309 */     for (ResG e : RESOURCES.EDI().all()) {
/* 310 */       HOVERABLE hOVERABLE1 = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 314 */             GFORMAT.i(text, -((IndustryResource)((ROOM_PRISON)Gui.this.blueprint).indu.ins().get(e.index())).history().get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 319 */             b.title(e.resource.name);
/* 320 */             b.textLL(Dic.¤¤Consumed).add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)((ROOM_PRISON)Gui.this.blueprint).indu.ins().get(e.index())).history().get()));
/* 321 */             b.NL();
/* 322 */             cc.clear();
/* 323 */             cc.add((HISTORY)((IndustryResource)((ROOM_PRISON)Gui.this.blueprint).indu.ins().get(e.index())).history());
/* 324 */             b.add((RENDEROBJ)cc);
/*     */           }
/* 328 */         }).hv((SPRITE)e.resource.icon());
/*     */       
/* 330 */       s.add((RENDEROBJ)hOVERABLE1, i % 4 * 42, i / 4 * 48);
/* 331 */       i++;
/*     */     } 
/*     */ 
/*     */     
/* 335 */     s.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 339 */             GFORMAT.iofk(text, ((ROOM_PRISON)Gui.this.blueprint).punishUsed(), ((ROOM_PRISON)Gui.this.blueprint).punishTotal());
/*     */           }
/* 341 */         }).hh(Dic.¤¤Capacity));
/*     */     
/* 343 */     text.add((RENDEROBJ)s);
/*     */ 
/*     */     
/* 346 */     RENDEROBJ r = null;
/*     */     
/* 348 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 352 */           GFORMAT.iofk(text, ((ROOM_PRISON)Gui.this.blueprint).punishUsed(), ((ROOM_PRISON)Gui.this.blueprint).punishTotal());
/*     */         }
/* 354 */       }).hh(((ROOM_PRISON)this.blueprint).constructor.prisoners.name()).hoverInfoSet(((ROOM_PRISON)this.blueprint).constructor.prisoners.desc());
/* 355 */     text.add((RENDEROBJ)hOVERABLE);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, PrisonInstance i) {
/* 360 */     box.NL();
/* 361 */     box.text(((ROOM_PRISON)this.blueprint).constructor.prisoners.name());
/* 362 */     box.add((SPRITE)GFORMAT.iofk(box.text(), i.prisoners(), i.prisonersMax()));
/*     */   }
/*     */ 
/*     */   
/*     */   static void mWarn(PrisonInstance ins) {
/* 367 */     (new Mess(¤¤mWTitle, ¤¤mWBody, ins.body().cX(), ins.body().cY())).send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void m(PrisonInstance ins) {
/* 373 */     (new Mess(¤¤mTitle, ¤¤mBody, ins.body().cX(), ins.body().cY())).send();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Mess
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private int tx;
/*     */     
/*     */     private int ty;
/*     */     private String desc;
/*     */     
/*     */     Mess(CharSequence title, CharSequence desc, int tx, int ty) {
/* 388 */       super(title);
/* 389 */       this.desc = String.valueOf(desc);
/* 390 */       this.tx = tx;
/* 391 */       this.ty = ty;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 397 */       paragraph(this.desc);
/* 398 */       section.addRelBody(16, DIR.N, (SETT.ROOMS()).PRISON.iconBig().scaled(2.0D));
/* 399 */       section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */           {
/*     */             protected void clickA() {
/* 402 */               VIEW.s().activate();
/* 403 */               (VIEW.s().getWindow()).centererTile.set(Gui.Mess.this.tx, Gui.Mess.this.ty);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */