/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.raiding.RaiderPortrait;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ final class Hoverer
/*     */ {
/*  26 */   GETTER.GETTER_IMP<WArmy> a = new GETTER.GETTER_IMP();
/*  27 */   private final GuiSection player = new GuiSection();
/*  28 */   private final GuiSection ai = new GuiSection();
/*     */   
/*     */   public Hoverer() {
/*  31 */     this.player.add((RENDEROBJ)ArmyInfo.info((GETTER<WArmy>)this.a));
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.ai.add((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  39 */             if (((WArmy)Hoverer.this.a.get()).faction() != null) {
/*  40 */               text.color((COLOR)((WArmy)Hoverer.this.a.get()).faction().banner().colorBGBright());
/*  41 */               text.add((CharSequence)(((WArmy)Hoverer.this.a.get()).faction()).name);
/*     */             } else {
/*  43 */               text.color(COLOR.WHITE85);
/*  44 */               if ((GAME.raiders()).current.army() == Hoverer.this.a.get()) {
/*  45 */                 text.add(((GAME.raiders()).current.current()).name);
/*     */               } else {
/*  47 */                 text.add(Dic.¤¤Rebels);
/*     */               } 
/*     */             } 
/*     */           }
/*  51 */         },  0, 0);
/*     */     
/*  53 */     this.ai.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  57 */             if (DIP.WAR().is((Faction)FACTIONS.player(), ((WArmy)Hoverer.this.a.get()).faction())) {
/*  58 */               text.errorify().add(Dic.¤¤Enemy);
/*     */             } else {
/*  60 */               text.normalify2().add(Dic.¤¤Neutral);
/*     */             } 
/*     */           }
/*  63 */         }).hh((SPRITE)(UI.icons()).s.flag));
/*     */     
/*  65 */     this.ai.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  69 */             if (((WArmy)Hoverer.this.a.get()).region() != null) {
/*  70 */               text.add((CharSequence)(((WArmy)Hoverer.this.a.get()).region()).info.name());
/*     */             }
/*     */           }
/*  73 */         }).hh((SPRITE)(UI.icons()).s.crossheir));
/*     */     
/*  75 */     this.ai.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  79 */             GFORMAT.iofkInv(text, AD.men(null).get(Hoverer.this.a.get()), AD.menTarget(null).get(Hoverer.this.a.get()));
/*     */           }
/*  82 */         }).hh((SPRITE)(UI.icons()).s.human), 200, 0);
/*     */     
/*  84 */     this.ai.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  88 */             GFORMAT.iIncr(text, (long)(GAME.battle()).power.get((WArmy)Hoverer.this.a.get()));
/*     */           }
/*  90 */         }).hh((SPRITE)(UI.icons()).s.fist));
/*     */     
/*  92 */     this.ai.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  96 */             ((WArmy)Hoverer.this.a.get()).state().info((WArmy)Hoverer.this.a.get(), text);
/*     */           }
/*  99 */         }).hh((SPRITE)(UI.icons()).s.arrow_right));
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.ai.addRelBody(16, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(64)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 107 */             if (((WArmy)Hoverer.this.a.get()).faction() != null) {
/* 108 */               (((WArmy)Hoverer.this.a.get()).faction().banner()).HUGE.render(r, this.body.x1(), this.body.y1());
/*     */             }
/* 110 */             else if ((GAME.raiders()).current.army() == Hoverer.this.a.get()) {
/* 111 */               RaiderPortrait.render(r, this.body.x1() - 8, this.body.y1() - 10, 2, ((GAME.raiders()).current.current()).indu, false);
/*     */             } else {
/* 113 */               (UI.icons()).l.rebel.huge.render(r, this.body.x1(), this.body.y1());
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 119 */     this.ai.body().incrW(160.0D);
/* 120 */     this.ai.body().incrH(20.0D);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, WArmy a) {
/* 124 */     this.a.set(a);
/* 125 */     box.title((CharSequence)a.name);
/* 126 */     if (a.faction() == FACTIONS.player()) {
/* 127 */       box.add((RENDEROBJ)this.player);
/*     */     } else {
/* 129 */       box.add((RENDEROBJ)this.ai);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\Hoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */