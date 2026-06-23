/*     */ package view.world.ui.battle;
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import world.WORLD;
/*     */ import world.battle.spec.WBattleSiege;
/*     */ import world.battle.spec.WBattleSpec;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class BattleSiege extends Battle {
/*  33 */   private static CharSequence ¤¤name = "Siege of {0}";
/*  34 */   private static CharSequence ¤¤desc = "Our armies are at the walls of an enemy settlement. Its garrison still defiant. What are your orders?";
/*     */   
/*  36 */   private static CharSequence ¤¤Wait = "Wait";
/*  37 */   private static CharSequence ¤¤WaitD = "Continue the siege and wait. Eventually the defenders will starve and tire.";
/*     */   
/*  39 */   private static CharSequence ¤¤Lift = "¤Lift";
/*  40 */   private static CharSequence ¤¤LiftD = "¤Lift and abort siege.";
/*     */   
/*  42 */   private static CharSequence ¤¤BesigeTime = "¤Besiege Time.";
/*  43 */   private static CharSequence ¤¤BesigeTimeD = "¤After a day of siege, the defenders will start dying. After a full year, the defenders should be dead."; private final ACTION close;
/*     */   
/*     */   static {
/*  46 */     D.ts(BattleSiege.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private WBattleSiege spec;
/*     */   
/*     */   BattleSiege(ACTION close) {
/*  53 */     super(¤¤desc);
/*  54 */     this.close = close;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence title(WBattleSpec g) {
/*  59 */     Region reg = (Region)(WORLD.REGIONS()).map.get(g.enemy.coo());
/*  60 */     if (reg == null)
/*  61 */       reg = (Region)(WORLD.REGIONS()).map.get(g.player.coo()); 
/*  62 */     Str.TMP.clear().add(¤¤name);
/*  63 */     Str.TMP.insert(0, (CharSequence)reg.info.name());
/*  64 */     return (CharSequence)Str.TMP;
/*     */   }
/*     */   
/*     */   GuiSection getS(WBattleSiege spec) {
/*  68 */     this.spec = spec;
/*  69 */     return get((WBattleSpec)spec);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected RENDEROBJ buttons() {
/*  75 */     GuiSection ss = new GuiSection();
/*     */ 
/*     */     
/*  78 */     GButt.ButtPanel bb = new Battle.Butt((SPRITE)(UI.icons()).s.cog, ¤¤AutoResolve)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  81 */           Text t = text.text();
/*  82 */           t.add(BattleSiege.¤¤autoD);
/*  83 */           t.insert(0, BattleSiege.this.g.victory ? Dic.¤¤Victory : (
/*  84 */               (BattleSiege.this.g.player.losses() >= BattleSiege.this.g.player.men()) ? BattleSiege.¤¤Annihilation : Dic.¤¤Defeat));
/*  85 */           t.insert(1, BattleSiege.this.g.player.losses());
/*  86 */           t.insert(2, BattleSiege.this.g.enemy.losses());
/*  87 */           text.add((SPRITE)t);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  93 */           super.render(r, ds, isActive, isSelected, isHovered);
/*  94 */           if (BattleSiege.this.g.victory) {
/*  95 */             OPACITY.O25.bind();
/*  96 */             COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/*  97 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 104 */           if (super.hover(mCoo)) {
/* 105 */             BattleSiege.this.setCas(false, true);
/* 106 */             return true;
/*     */           } 
/* 108 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 113 */           BattleSiege.this.close.exe();
/* 114 */           BattleSiege.this.g.auto();
/*     */         }
/*     */       };
/* 117 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 119 */     bb = new Battle.Butt((SPRITE)(SPRITES.icons()).s.clock, ¤¤Wait)
/*     */       {
/*     */         
/*     */         protected void clickA()
/*     */         {
/* 124 */           BattleSiege.this.close.exe();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 129 */     bb.hoverInfoSet(¤¤WaitD);
/* 130 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */     
/* 132 */     bb = new Battle.Butt((SPRITE)(SPRITES.icons()).s.arrow_left, ¤¤Lift)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 136 */           BattleSiege.this.close.exe();
/* 137 */           BattleSiege.this.spec.retreat();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 143 */           if (super.hover(mCoo)) {
/* 144 */             BattleSiege.this.setCas(true, false);
/* 145 */             return true;
/*     */           } 
/* 147 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 151 */     bb.hoverInfoSet(¤¤LiftD);
/* 152 */     ss.addRightC(0, (RENDEROBJ)bb);
/*     */ 
/*     */     
/* 155 */     GuiSection s = new GuiSection();
/* 156 */     s.addRightC(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 161 */             text.add('x').s();
/* 162 */             GFORMAT.f1(text, BattleSiege.this.spec.fortifications);
/*     */           }
/* 165 */         }).hh((SPRITE)(UI.icons()).m.fortification).hoverTitleSet(Dic.¤¤Fort).hoverInfoSet(Dic.¤¤FortD));
/*     */     
/* 167 */     s.addRightC(86, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 171 */             GFORMAT.perc(text, RD.MILITARY().besigeMul(BattleSiege.this.spec.besiged));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 177 */             b.title(BattleSiege.¤¤BesigeTime);
/* 178 */             b.text(BattleSiege.¤¤BesigeTimeD);
/* 179 */             b.NL();
/* 180 */             b.textLL(DicTime.¤¤Days);
/* 181 */             b.tab(6);
/* 182 */             b.add((SPRITE)GFORMAT.fofkInv(b.text(), WORLD.BATTLES().besigedTime(BattleSiege.this.spec.besiged) * TIME.secondsPerDayI(), 18.0D));
/* 183 */             b.NL();
/* 184 */             b.textLL(Dic.¤¤Value);
/* 185 */             b.tab(6);
/* 186 */             b.add((SPRITE)GFORMAT.perc(b.text(), RD.MILITARY().besigeMul(BattleSiege.this.spec.besiged)));
/*     */           }
/* 189 */         }).hh((SPRITE)(UI.icons()).m.time));
/*     */     
/* 191 */     ss.addRelBody(4, DIR.N, (RENDEROBJ)s);
/*     */     
/* 193 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleSiege.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */