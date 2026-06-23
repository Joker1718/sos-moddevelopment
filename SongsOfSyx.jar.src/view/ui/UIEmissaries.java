/*     */ package view.ui;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.emmi.EmiType;
/*     */ import game.faction.player.emmi.EmiTypeReg;
/*     */ import game.faction.player.emmi.EmiTypeRoy;
/*     */ import game.faction.player.emmi.Emissaries;
/*     */ import game.faction.royalty.Royalty;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public class UIEmissaries
/*     */   extends ISidePanel {
/*  40 */   private ArrayList<Data> data = new ArrayList(512);
/*  41 */   private int tot = 0;
/*     */ 
/*     */   
/*     */   public UIEmissaries() {
/*  45 */     titleSet(Emissaries.¤¤name);
/*     */ 
/*     */     
/*  48 */     while (this.data.hasRoom()) {
/*  49 */       this.data.add(new Data());
/*     */     }
/*  51 */     this.section.addRelBody(8, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  55 */             GFORMAT.iIncr(text, (int)(BOOSTABLES.CIVICS()).DIPLOMACY.get((BOOSTABLE_O)FACTIONS.player()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  61 */             (BOOSTABLES.CIVICS()).DIPLOMACY.hover((GUI_BOX)b, (BOOSTABLE_O)FACTIONS.player(), true);
/*     */           }
/*  63 */         }).hh((SPRITE)(BOOSTABLES.CIVICS()).DIPLOMACY.icon, (BOOSTABLES.CIVICS()).DIPLOMACY.name, 180));
/*     */     
/*  65 */     this.section.addRelBody(8, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  69 */             GFORMAT.perc(text, (FACTIONS.player()).emissaries.penaltyMul());
/*     */           }
/*  71 */         }).hh(Dic.¤¤Efficiency, 250));
/*     */     
/*  73 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  77 */           if (MButt.LEFT.isDown() && UIEmissaries.this.tot > 0) {
/*  78 */             return UIEmissaries.this.tot;
/*     */           }
/*     */           
/*  81 */           UIEmissaries.this.tot = 0;
/*  82 */           for (Region reg : WORLD.REGIONS().active()) {
/*  83 */             if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */               break; 
/*  85 */             for (EmiTypeReg t : (FACTIONS.player()).emissaries.regs) {
/*  86 */               if (t.get(reg) > 0) {
/*     */                 
/*  88 */                 ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).reg = reg;
/*  89 */                 ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).t = (EmiType<?>)t;
/*  90 */                 ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).treg = (EmiType<Region>)t;
/*  91 */                 UIEmissaries.this.tot++;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/*  97 */           for (FactionNPC f : FACTIONS.NPCs()) {
/*  98 */             if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */               break; 
/* 100 */             for (EmiTypeRoy t : (FACTIONS.player()).emissaries.roys) {
/* 101 */               for (Royalty r : f.court().all()) {
/* 102 */                 if (t.get(r) > 0) {
/* 103 */                   if (UIEmissaries.this.tot > UIEmissaries.this.data.size())
/*     */                     break; 
/* 105 */                   ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).roy = r;
/* 106 */                   ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).t = (EmiType<?>)t;
/* 107 */                   ((UIEmissaries.Data)UIEmissaries.this.data.get(UIEmissaries.this.tot)).troy = t;
/* 108 */                   UIEmissaries.this.tot++;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 115 */           return UIEmissaries.this.tot;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 121 */     bu.column(null, (new But((GETTER<Integer>)new GETTER.GETTER_IMP(Integer.valueOf(0)))).body().width(), new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 125 */             return (RENDEROBJ)new UIEmissaries.But(ier);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 130 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)bu.createHeight(HEIGHT - this.section.body().height() - 32, false));
/*     */   }
/*     */ 
/*     */   
/*     */   private class But
/*     */     extends GButt.BSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     private final GSliderInt sl;
/*     */ 
/*     */     
/*     */     But(GETTER<Integer> ier) {
/* 143 */       this.ier = ier;
/*     */       
/* 145 */       add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 149 */               text.lablify();
/* 150 */               text.add((UIEmissaries.But.this.d()).t.name);
/*     */             }
/* 152 */           }).r(DIR.NW));
/*     */       
/* 154 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 158 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 163 */             if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 164 */               return (UIEmissaries.But.this.d()).treg.max((UIEmissaries.But.this.d()).reg);
/*     */             }
/* 166 */             if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 167 */               return (UIEmissaries.But.this.d()).troy.max((UIEmissaries.But.this.d()).roy);
/*     */             }
/* 169 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 174 */             if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 175 */               return (UIEmissaries.But.this.d()).treg.get((UIEmissaries.But.this.d()).reg);
/*     */             }
/* 177 */             if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 178 */               return (UIEmissaries.But.this.d()).troy.get((UIEmissaries.But.this.d()).roy);
/*     */             }
/* 180 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 185 */             if (t == 0) {
/* 186 */               UIEmissaries.But.this.sl.reset();
/*     */             }
/* 188 */             if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 189 */               (UIEmissaries.But.this.d()).treg.set((UIEmissaries.But.this.d()).reg, t);
/*     */             }
/* 191 */             else if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 192 */               (UIEmissaries.But.this.d()).troy.set((UIEmissaries.But.this.d()).roy, t);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 197 */       this.sl = new GSliderInt(ii, 160, true, true);
/* 198 */       addRightCAbs(120, (RENDEROBJ)this.sl);
/*     */       
/* 200 */       add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 204 */               if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).treg) {
/* 205 */                 text.color(GCOLOR.T().faction((UIEmissaries.But.this.d()).reg.faction()));
/* 206 */                 text.add((CharSequence)(UIEmissaries.But.this.d()).reg.info.name());
/* 207 */               } else if ((UIEmissaries.But.this.d()).t == (UIEmissaries.But.this.d()).troy) {
/* 208 */                 (UIEmissaries.But.this.d()).roy.nameSucc((Str)text);
/*     */               } 
/*     */             }
/*     */           }, 
/* 212 */           ).r(DIR.NW), 0, body().y2() + 4);
/*     */ 
/*     */       
/* 215 */       addRelBody(8, DIR.W, (SPRITE)new SPRITE.Imp(32)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 218 */               (UIEmissaries.But.this.d()).t.icon.render(r, X1, X2, Y1, Y2);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 224 */       pad(6);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 230 */       super.hoverInfoGet(text);
/* 231 */       if ((d()).t == (d()).treg) {
/* 232 */         (d()).treg.hover((d()).reg, text);
/* 233 */         text.NL(8);
/* 234 */         (VIEW.world()).UI.regions.hover((d()).reg, text);
/*     */       }
/* 236 */       else if ((d()).t == (d()).troy) {
/* 237 */         (d()).troy.hover((d()).roy, text);
/* 238 */         text.NL(8);
/* 239 */         (VIEW.world()).UI.factions.hover(text, (Faction)(d()).roy.court.faction);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 247 */       if ((d()).t == (d()).treg) {
/* 248 */         VIEW.world().activate();
/* 249 */         (VIEW.world()).panels.addDontRemove(UIEmissaries.this, (VIEW.world()).UI.regions.get((d()).reg));
/*     */       }
/* 251 */       else if ((d()).t == (d()).troy) {
/* 252 */         (VIEW.world()).UI.factions.open((d()).roy.court.faction);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private UIEmissaries.Data d() {
/* 258 */       return (UIEmissaries.Data)UIEmissaries.this.data.get(((Integer)this.ier.get()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private class Data {
/*     */     EmiType<?> t;
/*     */     EmiTypeRoy troy;
/*     */     EmiType<Region> treg;
/*     */     Royalty roy;
/*     */     Region reg;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\UIEmissaries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */