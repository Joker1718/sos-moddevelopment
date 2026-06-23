/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.Debugger;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.profile.UIBonus;
/*     */ import view.ui.util.UIValues;
/*     */ 
/*     */ 
/*     */ final class UIFaction
/*     */   extends ISidePanel
/*     */ {
/*     */   private final GETTER.GETTER_IMP<FactionNPC> f;
/*     */   private final CLICKABLE.ClickSwitch sw;
/*     */   private final UIDiplomacy dip;
/*     */   
/*     */   UIFaction(final GETTER.GETTER_IMP<FactionNPC> f, Deal deal, int WIDTH, int HEIGHT) {
/*  37 */     this.f = f;
/*  38 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  42 */           if (f.get() == null)
/*     */             return; 
/*  44 */           if (!((FactionNPC)f.get()).isActive()) {
/*  45 */             f.set(null);
/*     */             return;
/*     */           } 
/*  48 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  53 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*  54 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)new Banner((GETTER<FactionNPC>)this.f, WIDTH));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     GuiSection butts = new GuiSection();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     Court court = new Court((GETTER<FactionNPC>)f, WIDTH, HEIGHT - 40 - this.section.body().height());
/*  66 */     this.sw = new CLICKABLE.ClickSwitch((RENDEROBJ)court);
/*  67 */     this.sw.setD(DIR.N);
/*  68 */     butts.addRightC(0, (RENDEROBJ)sb(Dic.¤¤Court, (CLICKABLE)court));
/*     */ 
/*     */     
/*  71 */     int hi = HEIGHT - this.section.body().height() - butts.body().height() - 24;
/*  72 */     this.dip = new UIDiplomacy((GETTER<FactionNPC>)f, deal, hi);
/*  73 */     butts.addRightC(0, (RENDEROBJ)sb(Dic.¤¤Realm, (CLICKABLE)new Realm(f, hi)));
/*  74 */     butts.addRightC(0, (RENDEROBJ)sb(Dic.¤¤goods, (CLICKABLE)new Goods((GETTER<FactionNPC>)f, hi)));
/*     */     
/*  76 */     GETTER<BOOSTABLE_O> bbb = new GETTER<BOOSTABLE_O>()
/*     */       {
/*     */         public BOOSTABLE_O get()
/*     */         {
/*  80 */           return (BOOSTABLE_O)f.get();
/*     */         }
/*     */       };
/*     */     
/*  84 */     GETTER<Faction> fff = new GETTER<Faction>()
/*     */       {
/*     */         public Faction get()
/*     */         {
/*  88 */           return (Faction)f.get();
/*     */         }
/*     */       };
/*     */     
/*  92 */     butts.addRightC(0, (RENDEROBJ)sb(Dic.¤¤Boosts, (CLICKABLE)new UIBonus(bbb, fff, hi)
/*     */           {
/*     */             protected boolean is(Boostable bo)
/*     */             {
/*  96 */               return !(bo.cat != BOOSTABLES.BATTLE() && bo.cat != BOOSTABLES.ROOMS());
/*     */             }
/*     */           }));
/*     */ 
/*     */ 
/*     */     
/* 102 */     butts.addRightC(0, (RENDEROBJ)sb(Dic.¤¤Diplomacy, (CLICKABLE)this.dip));
/* 103 */     if ((S.get()).developer) {
/* 104 */       butts.addRightC(0, (RENDEROBJ)UIValues.butt(GVALUES.FACTION, fff));
/* 105 */       butts.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 109 */               Debugger.DebuggerSection debuggerSection = new Debugger.DebuggerSection(800)
/*     */                 {
/*     */                   protected void fill(Debugger d)
/*     */                   {
/* 113 */                     ((FactionNPC)f.get()).debug(d);
/*     */                   }
/*     */                 };
/*     */               
/* 117 */               (VIEW.inters()).popup.show((RENDEROBJ)debuggerSection, (CLICKABLE)this);
/* 118 */               super.clickA();
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 124 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)butts);
/* 125 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(WIDTH - 128, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 129 */             GCOLOR.UI().border(r, body().x1(), body().x2(), body().y1() + 5, body().y1() + 8);
/*     */           }
/*     */         });
/* 132 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)this.sw);
/* 133 */     this.section.body().setWidth(WIDTH).setHeight(HEIGHT);
/*     */   }
/*     */   
/*     */   public void dip() {
/* 137 */     this.sw.set((RENDEROBJ)this.dip);
/*     */   }
/*     */   
/*     */   public boolean dipIS() {
/* 141 */     return (this.sw.current() == this.dip);
/*     */   }
/*     */ 
/*     */   
/*     */   private CLICKABLE sb(CharSequence name, final CLICKABLE s) {
/* 146 */     GButt.ButtPanel b = new GButt.ButtPanel(name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 150 */           UIFaction.this.sw.set((RENDEROBJ)s);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 155 */           selectedSet((UIFaction.this.sw.current() == s));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 160 */     b.body.setWidth(140.0D);
/* 161 */     return (CLICKABLE)b;
/*     */   }
/*     */   
/*     */   public Faction f() {
/* 165 */     return (Faction)this.f.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFaction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */