/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.message.MessageText;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public class RDHealth
/*     */   extends RData.RDataE {
/*  28 */   public static CharSequence ¤¤name = "¤Health";
/*  29 */   public static CharSequence ¤¤desc = "¤Health must be maintained at over 50% in a region, else there is a risk of disease.";
/*     */   
/*  31 */   private static CharSequence ¤¤pos = "¤You have health moving towards more than 50% and need not fear an outbreak of disease.";
/*  32 */   private static CharSequence ¤¤neg = "¤You have health plummeting  below 50%, and an outbreak of disease is to be expected.";
/*  33 */   private static CharSequence ¤¤out = "¤This region is currently suffering from an outbreak of disease. You must increase health quickly.";
/*  34 */   private static CharSequence ¤¤targetE = "¤At pop Target";
/*     */   
/*  36 */   static CharSequence ¤¤epidemic = "¤Outbreak";
/*  37 */   private static CharSequence ¤¤epidemicD = "¤The region of {0} has suffered from low health and as a result there has been an outbreak of disease. While the epidemic is lasting, the region will suffer big penalties across the board. You must increase the health to over 50% in order to save the settlement.";
/*     */   public final Boostable boostablee;
/*     */   
/*     */   static {
/*  41 */     D.ts(RDHealth.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final RData.RDataE outbreak;
/*     */   
/*     */   private boolean btoggle = true;
/*  48 */   private static double dTime = 1.0D / (TIME.secondsPerDay() * 2);
/*     */   
/*     */   private CharSequence eDesc(Region reg) {
/*  51 */     Str.TMP.clear().add(¤¤epidemicD).insert(0, (CharSequence)reg.info.name());
/*  52 */     return (CharSequence)Str.TMP;
/*     */   }
/*     */   
/*     */   public void hover(GBox b, Region reg) {
/*  56 */     b.title((RD.HEALTH()).boostablee.name);
/*  57 */     b.text((RD.HEALTH()).boostablee.desc);
/*  58 */     b.NL(4);
/*     */     
/*  60 */     if (this.outbreak.isMax(reg)) {
/*  61 */       b.error((CharSequence)b.text().clear().add(¤¤out).insert(0, (CharSequence)reg.info.name()));
/*  62 */     } else if (this.boostablee.get((BOOSTABLE_O)reg) < 0.5D) {
/*  63 */       b.add((SPRITE)b.text().warnify().add(¤¤neg));
/*     */     } else {
/*  65 */       b.add((SPRITE)b.text().normalify2().add(¤¤pos));
/*     */     } 
/*  67 */     b.NL(4);
/*     */     
/*  69 */     b.textLL(Dic.¤¤Current);
/*  70 */     b.tab(6);
/*  71 */     b.add((SPRITE)GFORMAT.perc(b.text(), getD(reg)));
/*  72 */     b.NL();
/*  73 */     b.textLL(Dic.¤¤Target);
/*  74 */     b.tab(6);
/*  75 */     b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(this.boostablee.get((BOOSTABLE_O)reg), 0.0D, 1.0D)));
/*  76 */     b.NL();
/*  77 */     b.textLL(¤¤targetE);
/*  78 */     boolean bb = this.btoggle;
/*  79 */     this.btoggle = false;
/*  80 */     b.tab(6);
/*  81 */     b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(this.boostablee.get((BOOSTABLE_O)reg), 0.0D, 1.0D)));
/*  82 */     b.NL();
/*  83 */     this.btoggle = bb;
/*     */     
/*  85 */     b.sep();
/*  86 */     this.boostablee.hover((GUI_BOX)b, (BOOSTABLE_O)reg, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void problem(GBox b, Region reg) {
/*  91 */     if (this.outbreak.isMax(reg)) {
/*  92 */       b.NL();
/*  93 */       b.error((CharSequence)b.text().clear().add(¤¤out).insert(0, (CharSequence)reg.info.name()));
/*  94 */       b.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   RDHealth(RD.RDInit init) {
/* 101 */     super("HEALTH", (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "HEALTH"), init, ¤¤name);
/* 102 */     this.boostablee = BOOSTING.push("HEALTH", 1.0D, ¤¤name, ¤¤desc, (SPRITE)(UI.icons()).s.heart, (BoostableCat.ALL()).WORLD);
/*     */     
/* 104 */     (new RBooster(new BSourceInfo(Dic.¤¤Population, (SPRITE)(UI.icons()).s.human), 0.0D, -8.0D, false)
/*     */       {
/*     */         public double get(Region t)
/*     */         {
/* 108 */           if (RDHealth.this.btoggle)
/* 109 */             return (RD.RACES()).capacityCurrent.get(t) / RD.RACES().maxPop(t); 
/* 110 */           return RD.RACES().capacity(t) / RD.RACES().maxPop(t);
/*     */         }
/* 114 */       }).add(this.boostablee);
/*     */     
/* 116 */     init.count.getClass(); this.outbreak = new RData.RDataE("OUTBREAK", (INT_O.INT_OE<Region>)new DataO.DataBit(init.count, "OUTBREAK"), init, ¤¤epidemic);
/*     */     
/* 118 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 122 */             RBooster bo = new RBooster(new BSourceInfo(RDHealth.¤¤epidemic, (SPRITE)(UI.icons()).s.death), 1.0D, 0.0D, true)
/*     */               {
/*     */                 protected double get(Region reg)
/*     */                 {
/* 126 */                   return (RDHealth.null.access$0(RDHealth.null.this)).outbreak.get(reg);
/*     */                 }
/*     */               };
/* 129 */             for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/* 130 */               bo.add(o.boost);
/* 131 */               bo.add(o.boostYearlyPart);
/*     */             } 
/* 133 */             bo = new RBooster(new BSourceInfo(RDHealth.¤¤epidemic, (SPRITE)(UI.icons()).s.death), 1.0D, 0.0D, true)
/*     */               {
/*     */                 protected double get(Region reg)
/*     */                 {
/* 137 */                   return (RDHealth.null.access$0(RDHealth.null.this)).outbreak.get(reg);
/*     */                 }
/*     */               };
/* 140 */             bo.add((RD.RACES()).capacity);
/*     */           }
/*     */         });
/*     */     
/* 144 */     init.upers.add(new RD.RDUpdatable()
/*     */         {
/*     */           
/*     */           public void update(Region reg, double time)
/*     */           {
/* 149 */             if (reg.faction() == null || reg.faction() instanceof game.faction.npc.FactionNPC) {
/* 150 */               RDHealth.this.set(reg, 255);
/*     */               
/*     */               return;
/*     */             } 
/* 154 */             double b = RDHealth.this.boostablee.get((BOOSTABLE_O)reg);
/* 155 */             boolean bb = RDHealth.this.btoggle;
/* 156 */             RDHealth.this.btoggle = true;
/* 157 */             b = Math.max(b, RDHealth.this.boostablee.get((BOOSTABLE_O)reg));
/*     */             
/* 159 */             int target = CLAMP.i((int)(255.0D * b), 0, 255);
/* 160 */             RDHealth.this.btoggle = bb;
/*     */             
/* 162 */             RDHealth.this.moveTo(reg, time * RDHealth.dTime, target);
/*     */             
/* 164 */             if (reg.faction() == FACTIONS.player() && !reg.capitol()) {
/* 165 */               if (RDHealth.this.get(reg) < 120 && RDHealth.this.outbreak.get(reg) == 0 && target < 120) {
/* 166 */                 RDHealth.this.outbreak.set(reg, 1);
/* 167 */                 (new MessageText(RDHealth.¤¤epidemic)).paragraph(RDHealth.this.eDesc(reg)).send();
/* 168 */               } else if (RDHealth.this.outbreak.get(reg) == 1 && RDHealth.this.get(reg) > 128 && target > 128) {
/* 169 */                 RDHealth.this.outbreak.set(reg, 0);
/*     */               } 
/*     */             }
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void init(Region reg) {
/* 180 */             RDHealth.this.setD(reg, 1.0D);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDHealth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */