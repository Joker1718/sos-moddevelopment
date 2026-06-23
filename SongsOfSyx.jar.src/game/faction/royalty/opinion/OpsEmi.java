/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.emmi.EmiTypeRoy;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.world.ui.faction.UIRoyalty;
/*     */ 
/*     */ public final class OpsEmi {
/*  22 */   private static CharSequence ¤¤flattery = "Flattery";
/*  23 */   private static CharSequence ¤¤dflatteryD = "Flattery From your Emissaries.";
/*     */   
/*  25 */   private static CharSequence ¤¤sabotage = "Sabotage";
/*  26 */   private static CharSequence ¤¤sabotageD = "Sabotage from your Emissaries.";
/*     */   
/*  28 */   private static CharSequence ¤¤assasination = "Assassinations";
/*  29 */   private static CharSequence ¤¤assasinationD = "Assassinations of court members.";
/*     */   
/*  31 */   private static CharSequence ¤¤assasinated = "Assassinated!";
/*  32 */   private static CharSequence ¤¤assasinatedSucc = "Our emissaries report, their mission is done. The great lord of {FACTION} slipped last night on their nightdress, leading to a fall down the stone stairs of {HIS} bed chamber. Once down, a chandelier happened to fall on top of {NAME}'s head, crushing the skull completely. What a tragedy!";
/*     */   
/*  34 */   private static CharSequence ¤¤assasinatedFail = "Busted!";
/*  35 */   private static CharSequence ¤¤assasinatedFailD = "One of our emissaries serving in the court of {FACTION} was arrested and tortured. Unfortunately, our plans have been compromised. {NAME} knows this, and is not too happy about it. Our 'attempts' will continue, but it will be harder now.";
/*     */   
/*     */   static {
/*  38 */     D.ts(OpsEmi.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final ROpper good;
/*     */   private final ROpper bad;
/*     */   private final ROpper assas;
/*     */   
/*     */   OpsEmi() {
/*  47 */     final double year = (16 * TIME.secondsPerDay());
/*     */     
/*  49 */     this.good = new ROpper("EMMI_GOOD", ¤¤flattery, ¤¤dflatteryD, (SPRITE)(UI.icons()).s.gift, 80.0D, false)
/*     */       {
/*     */         public double increase(Royalty roy)
/*     */         {
/*  53 */           double v = this.value.getD(roy);
/*     */           
/*  55 */           double target = ptarget(roy);
/*  56 */           if (target > v)
/*  57 */             return 1.0D / year * 2.0D; 
/*  58 */           if (target < v) {
/*  59 */             return -1.0D / year * 0.5D;
/*     */           }
/*  61 */           return 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/*  70 */           return OpsEmi.this.vv(bo, (FACTIONS.player()).emissaries.flatter, this, (FACTIONS.player()).emissaries.penaltyMul());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  75 */     this.bad = new ROpper("EMMI_BAD", ¤¤sabotage, ¤¤sabotageD, (SPRITE)(UI.icons()).s.gift, -160.0D, false)
/*     */       {
/*     */         public double increase(Royalty roy)
/*     */         {
/*  79 */           double v = this.value.getD(roy);
/*     */           
/*  81 */           double target = ptarget(roy);
/*  82 */           if (target > v) {
/*  83 */             return 1.0D / year * 2.0D;
/*     */           }
/*  85 */           if (target < v) {
/*  86 */             return -1.0D / year * 0.5D;
/*     */           }
/*  88 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/*  93 */           return OpsEmi.this.vv(bo, (FACTIONS.player()).emissaries.sabotage, this, (FACTIONS.player()).emissaries.penaltyMul());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  98 */     this.assas = new ROpper.ROpperDown("EMMI_ASSES", ¤¤assasination, ¤¤assasinationD, (SPRITE)(UI.icons()).s.death, -10.0D, false, year * 4.0D)
/*     */       {
/*     */         
/*     */         public void update(Royalty roy, double time)
/*     */         {
/* 103 */           double t = OpsEmi.this.assasinationsPerYear(roy, (FACTIONS.player()).emissaries.penaltyMul());
/* 104 */           t = time * t / year;
/* 105 */           int a = (int)this.state.getD(roy);
/* 106 */           this.state.incD(roy, t);
/* 107 */           int n = (int)this.state.getD(roy);
/* 108 */           if (a != n) {
/* 109 */             this.state.incD(roy, -n);
/* 110 */             long ran = STATS.RAN().getL(roy.induvidual, a % 32);
/* 111 */             if ((ran & 0x3L) == 0L) {
/* 112 */               OpsEmi.this.assasinate(roy, true);
/* 113 */               (GAME.count()).ROYALTIES_KILLED.inc(1);
/*     */             } else {
/* 115 */               OpsEmi.this.assasinate(roy, false);
/*     */             } 
/*     */           } 
/* 118 */           super.update(roy, time);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double vv(Royalty roy, EmiTypeRoy em, ROpper op, double eff) {
/* 127 */     return em.get(roy) * valuePerEmissary(roy.court.faction) * eff / Math.abs(op.to());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double valuePerEmissary(FactionNPC f) {
/* 138 */     return 768000.0D / FACTIONS.WORTH().faction((Faction)f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void assasinate(Royalty roy, boolean kill) {
/* 143 */     this.assas.value.incD(roy, 0.25D);
/* 144 */     if (kill) {
/* 145 */       roy.kill(false);
/* 146 */       (new Mess(¤¤assasinated, ¤¤assasinatedSucc, roy)).send();
/*     */     } else {
/* 148 */       (new Mess(¤¤assasinatedFail, ¤¤assasinatedFailD, roy)).send();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double assasinationsPerYear(Royalty roy, double efficiency) {
/* 154 */     double t = (FACTIONS.player()).emissaries.assasinate.get(roy) * valuePerEmissary(roy.court.faction) * (FACTIONS.player()).emissaries.penaltyMul();
/* 155 */     t /= 1.0D + this.assas.value.getD(roy) * 4.0D;
/* 156 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double opinionTarget(Royalty roy, double efficiency) {
/* 163 */     double oldg = this.good.value.getD(roy);
/* 164 */     double oldb = this.bad.value.getD(roy);
/*     */     
/* 166 */     this.good.value.setD(roy, vv(roy, (FACTIONS.player()).emissaries.flatter, this.good, efficiency));
/* 167 */     this.bad.value.setD(roy, vv(roy, (FACTIONS.player()).emissaries.sabotage, this.bad, efficiency));
/* 168 */     double res = ROPINION.get(roy);
/* 169 */     this.good.value.setD(roy, oldg);
/* 170 */     this.bad.value.setD(roy, oldb);
/* 171 */     return res;
/*     */   }
/*     */   
/*     */   public double trustTarget(Royalty roy, double efficiency) {
/* 175 */     double oldg = this.good.value.getD(roy);
/* 176 */     double oldb = this.bad.value.getD(roy);
/*     */     
/* 178 */     this.good.value.setD(roy, vv(roy, (FACTIONS.player()).emissaries.flatter, this.good, efficiency));
/* 179 */     this.bad.value.setD(roy, vv(roy, (FACTIONS.player()).emissaries.sabotage, this.bad, efficiency));
/* 180 */     double res = ROPINION.trust().get(roy.court.faction);
/* 181 */     this.good.value.setD(roy, oldg);
/* 182 */     this.bad.value.setD(roy, oldb);
/* 183 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Mess
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final String desc;
/*     */     private final Induvidual indu;
/*     */     private final String name;
/*     */     private final String fName;
/*     */     private int sI;
/*     */     
/*     */     public Mess(CharSequence title, CharSequence desc, Royalty roy) {
/* 199 */       super(title);
/* 200 */       this.desc = String.valueOf(desc);
/* 201 */       this.name = String.valueOf(roy.name());
/* 202 */       this.indu = roy.induvidual;
/* 203 */       this.sI = roy.successionI();
/* 204 */       this.fName = String.valueOf(roy.court.faction.name);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 209 */       paragraph((CharSequence)Str.TMP.clear().add(this.desc).insert("NAME", this.name).insert("FACTION", this.fName).insert("HIS", (this.indu.race()).info.pHIS.get(this.indu, false)));
/* 210 */       section.addRelBody(8, DIR.N, (SPRITE)new UIRoyalty.PortraitAbs(4)
/*     */           {
/*     */             protected int succ()
/*     */             {
/* 214 */               return OpsEmi.Mess.this.sI;
/*     */             }
/*     */ 
/*     */             
/*     */             protected Induvidual indu() {
/* 219 */               return OpsEmi.Mess.this.indu;
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsEmi.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */