/*     */ package settlement.room.law.guard;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.settings.S;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.ui.div.UIGuardDivSelector;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<GuardInstance, ROOM_GUARD> {
/*  29 */   private static CharSequence ¤¤guards = "Guard Force";
/*  30 */   private static CharSequence ¤¤effDesc = "Degrade and employment determines the efficiency of a guard-post.";
/*     */   
/*     */   static {
/*  33 */     D.ts(Gui.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Gui(ROOM_GUARD s) {
/*  38 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<GuardInstance> g, int x1, int y1) {
/*  46 */     section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  50 */             GFORMAT.perc(text, ((GuardInstance)g.get()).eff());
/*     */           }
/*  52 */         }).hv(Dic.¤¤Efficiency, ¤¤effDesc));
/*     */ 
/*     */     
/*  55 */     if ((S.get()).developer) {
/*  56 */       section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  60 */               SETT.OVERLAY().envThing((SETT.ENV()).map.GUARD);
/*  61 */               GFORMAT.i(text, ((ROOM_GUARD)Gui.this.blueprint).reporter.crimes((GuardInstance)g.get()));
/*  62 */               text.s().add(((ROOM_GUARD)Gui.this.blueprint).reporter.crimes(null));
/*     */             }
/*  64 */           }).hv("crimes"));
/*     */       
/*  66 */       section.addRelBody(16, DIR.S, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  70 */               GFORMAT.i(text, ((ROOM_GUARD)Gui.this.blueprint).reporter.executions((GuardInstance)g.get()));
/*  71 */               text.s().add(((ROOM_GUARD)Gui.this.blueprint).reporter.executions(null));
/*     */             }
/*  73 */           }).hv("executions"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/*  80 */     GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  84 */     s.add((RENDEROBJ)new GHeader(¤¤guards));
/*     */     
/*  86 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  90 */             int a = 0;
/*  91 */             for (Div d : GAME.ARMIES().player().divisions()) {
/*  92 */               if (((ROOM_GUARD)Gui.this.blueprint).activeDuty.is(d))
/*  93 */                 a++; 
/*  94 */             }  GFORMAT.i(text, a);
/*     */           }
/*  96 */         }).hh(Dic.¤¤Divisions, 120));
/*     */ 
/*     */ 
/*     */     
/* 100 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 104 */             GFORMAT.i(text, STATS.POP().pop(HTYPES.GUARD()));
/*     */           }
/* 106 */         }).hh(Dic.¤¤Soldiers, 120), 0, s.body().y2() + 4);
/*     */     
/* 108 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 112 */             GFORMAT.f0(text, ((ROOM_GUARD)Gui.this.blueprint).power.get());
/*     */           }
/* 114 */         }).hh(Dic.¤¤Power, 120), 0, s.body().y2() + 4);
/*     */     
/* 116 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 120 */             GFORMAT.perc(text, (SETT.ENV()).map.GUARD.stat().data().getD(null));
/*     */           }
/* 122 */         }).hh((STATS.ENV()).info.name, 120), 0, s.body().y2() + 4);
/*     */     
/* 124 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 128 */             GFORMAT.f0(text, ((ROOM_GUARD)Gui.this.blueprint).averageUpgrade());
/*     */           }
/* 130 */         }).hh(Dic.¤¤Upgrade, 120), 0, s.body().y2() + 4);
/*     */ 
/*     */ 
/*     */     
/* 134 */     s.addRelBody(64, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.shield)
/*     */         {
/* 136 */           RENDEROBJ oo = (RENDEROBJ)new UIGuardDivSelector();
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 141 */             (VIEW.inters()).popup.show(this.oo, (CLICKABLE)this);
/*     */           }
/* 144 */         }).pad(8, 8));
/*     */     
/* 146 */     if ((S.get()).developer) {
/* 147 */       s.addDown(2, (RENDEROBJ)((ROOM_GUARD)this.blueprint).patrols.debugButt());
/*     */     }
/*     */     
/* 150 */     text.section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */   
/*     */   protected void hover(GBox box, GuardInstance i) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */