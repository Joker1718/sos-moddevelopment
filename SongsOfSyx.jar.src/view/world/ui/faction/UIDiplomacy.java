/*     */ package view.world.ui.faction;
/*     */ import game.GAME;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealDrawfter;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.OpsStance;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.Debugger;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.diplomacy.UIDealConfig;
/*     */ import view.ui.diplomacy.UIDealList;
/*     */ 
/*     */ final class UIDiplomacy extends GuiSection {
/*  33 */   private static CharSequence ¤¤What = "What do you wish to offer us?";
/*  34 */   private static CharSequence ¤¤Barter = "Barter";
/*  35 */   private static CharSequence ¤¤BarterD = "Allow the Faction to compose a deal that they feel comfortable with based on your demands.";
/*  36 */   private static CharSequence ¤¤desc = "The value of a deal is weighed by the faction's perception of the value of its components. A deal needs to have a possible value in order to go through. A high positive value indicate generosity on your part, and will increase the faction's opinion of you.";
/*  37 */   private static CharSequence ¤¤Accept = "The deal will be accepted";
/*  38 */   private static CharSequence ¤¤AcceptNo = "The deal will not be accepted";
/*  39 */   private static CharSequence ¤¤OpinionD = "The change of opinion of the faction's ruler if this deal is accepted.";
/*  40 */   private static CharSequence ¤¤No = "You have nothing of worth to offer the faction."; private final Deal deal;
/*     */   
/*     */   static {
/*  43 */     D.ts(UIDiplomacy.class);
/*     */   }
/*     */ 
/*     */   
/*  47 */   public final GuiSection section = new GuiSection();
/*  48 */   private double timer = 0.0D;
/*     */ 
/*     */   
/*     */   public UIDiplomacy(GETTER<FactionNPC> g, final Deal deal, int height) {
/*  52 */     this.deal = new Deal();
/*     */     
/*  54 */     addRelBody(0, DIR.S, (SPRITE)(new GText((UI.FONT()).M, ¤¤What)).lablifySub());
/*     */     
/*  56 */     GuiSection op = new GuiSection();
/*     */ 
/*     */     
/*  59 */     op.addRightC(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  63 */             GFORMAT.iIncr(text, (long)deal.valueCredits());
/*     */           }
/*  65 */         }).hh(Dic.¤¤Value).hoverInfoSet(¤¤desc));
/*     */     
/*  67 */     op.addRightC(100, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  72 */             GFORMAT.f0(text, deal.opinionChange());
/*     */           }
/*  74 */         }).hh(ROPINION.¤¤name).hoverInfoSet(¤¤OpinionD));
/*     */     
/*  76 */     op.addRightC(100, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  81 */             GFORMAT.f0(text, -deal.betrayal());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  86 */             deal.hoverBetrayal(b);
/*     */           }
/*  89 */         }).hh(OpsStance.¤¤betrayal));
/*     */     
/*  91 */     op.addRightC(100, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/*  95 */             activeSet(!(!deal.canBeAccepted() && !(S.get()).developer));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 100 */             if (deal.canBeAccepted() || (S.get()).developer) {
/* 101 */               deal.execute(true);
/*     */             }
/* 103 */             super.clickA();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 109 */             GBox b = (GBox)text;
/* 110 */             b.text(UIDiplomacy.¤¤desc);
/*     */ 
/*     */             
/* 113 */             b.NL(8);
/* 114 */             b.textLL(Dic.¤¤Value);
/* 115 */             b.tab(6);
/* 116 */             b.add((SPRITE)(UI.icons()).s.money);
/* 117 */             b.add((SPRITE)GFORMAT.i(b.text(), (long)deal.valueCredits()));
/*     */ 
/*     */ 
/*     */             
/* 121 */             b.NL();
/* 122 */             b.textLL(ROPINION.¤¤name);
/* 123 */             b.tab(6);
/*     */             
/* 125 */             b.add((SPRITE)GFORMAT.f0(b.text(), deal.opinionChange()));
/* 126 */             GText t = b.text();
/* 127 */             t.add('(');
/* 128 */             GFORMAT.f(t, ROPINION.get(deal.npc.npc()));
/* 129 */             t.add(')');
/* 130 */             b.add((SPRITE)t);
/*     */ 
/*     */ 
/*     */             
/* 134 */             b.NL(8);
/* 135 */             if (deal.canBeAccepted()) {
/* 136 */               b.textL(UIDiplomacy.¤¤Accept);
/*     */             } else {
/* 138 */               b.error(UIDiplomacy.¤¤AcceptNo);
/*     */             }
/*     */           
/*     */           }
/* 142 */         }).hoverInfoSet(¤¤desc);
/*     */     
/* 144 */     op.addRightC(16, (RENDEROBJ)new GButt.ButtPanel(¤¤Barter)
/*     */         {
/*     */           
/* 147 */           private GTextR t = (new GText((UI.FONT()).M, UIDiplomacy.¤¤No)).warnify().r(DIR.N);
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 151 */             DealDrawfter.draft(deal, true, true);
/* 152 */             if (deal.hasDeal() && !deal.canBeAccepted()) {
/* 153 */               UIDiplomacy.this.timer = 5.0D;
/* 154 */               (VIEW.inters()).popup.show((RENDEROBJ)this.t, (CLICKABLE)this);
/*     */             } 
/* 156 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 161 */             activeSet(deal.hasDeal());
/*     */           }
/* 164 */         }).hoverInfoSet(¤¤BarterD);
/*     */     
/* 166 */     if ((S.get()).developer) {
/* 167 */       op.addRightC(16, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 171 */               Debugger.DebuggerSection debuggerSection = new Debugger.DebuggerSection(700)
/*     */                 {
/*     */                   protected void fill(Debugger d)
/*     */                   {
/* 175 */                     deal.setFactionAndClear(deal.npc.npc(), false, d);
/*     */                   }
/*     */                 };
/* 178 */               (VIEW.inters()).popup.show((RENDEROBJ)debuggerSection, (CLICKABLE)this);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 183 */               activeSet(deal.hasDeal());
/*     */             }
/* 186 */           }).hoverInfoSet(¤¤BarterD);
/*     */     }
/*     */ 
/*     */     
/* 190 */     int h = height - body().height() - op.body().height() - 16;
/*     */ 
/*     */ 
/*     */     
/* 194 */     GuiSection s = new GuiSection();
/*     */     
/* 196 */     s.add((RENDEROBJ)new UIDealConfig(deal, h));
/* 197 */     s.addRelBody(16, DIR.E, (SPRITE)new SPRITE.Imp(1, h)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 201 */             GCOLOR.UI().border().render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/* 204 */     s.addRelBody(16, DIR.E, (RENDEROBJ)new UIDealList(deal, h));
/*     */     
/* 206 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     
/* 208 */     addRelBody(8, DIR.S, (RENDEROBJ)op);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 215 */     GAME.SPEED.tmpPause();
/* 216 */     if (this.timer > 0.0D) {
/* 217 */       this.timer -= ds;
/* 218 */       if (this.timer <= 0.0D)
/* 219 */         (VIEW.inters()).popup.close(); 
/*     */     } 
/* 221 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void openPeace(FactionNPC other) {
/* 226 */     GAME.SPEED.tmpPause();
/* 227 */     this.deal.setFactionAndClear(other, true);
/* 228 */     DealDrawfter.draftPeace(this.deal, other, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIDiplomacy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */