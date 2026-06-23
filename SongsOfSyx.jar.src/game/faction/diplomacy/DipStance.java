/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class DipStance
/*     */   implements MAPPED {
/*  20 */   private final List list = new List();
/*     */   
/*     */   public final CharSequence name;
/*     */   public final CharSequence desc;
/*     */   public final SPRITE icon;
/*     */   public final boolean trades;
/*     */   public final boolean transit;
/*     */   public final boolean ally;
/*     */   public final double loyalty;
/*     */   public final double opinionNeeded;
/*     */   public final double tarif;
/*     */   private final int index;
/*     */   private final String key;
/*     */   
/*     */   DipStance(LISTE<DipStance> all, String key, double loyalty, double minLoyalty, double tarif, boolean trades, boolean transit, boolean ally, CharSequence name, CharSequence desc, SPRITE icon) {
/*  35 */     this.name = name;
/*  36 */     this.desc = desc;
/*  37 */     this.icon = icon;
/*  38 */     this.trades = trades;
/*  39 */     this.transit = transit;
/*  40 */     this.ally = ally;
/*  41 */     this.index = all.add(this);
/*  42 */     this.key = key;
/*  43 */     this.loyalty = loyalty;
/*  44 */     this.opinionNeeded = minLoyalty;
/*  45 */     this.tarif = tarif;
/*     */   }
/*     */   
/*     */   public boolean is(Faction faction, Faction other) {
/*  49 */     return DIP.s.is(faction, other, this);
/*     */   }
/*     */   
/*     */   public final boolean is(FactionNPC faction) {
/*  53 */     return is((Faction)faction, (Faction)FACTIONS.player());
/*     */   }
/*     */   
/*     */   public final void set(Faction instigator, Faction accepter) {
/*  57 */     DIP.s.set(instigator, accepter, this);
/*     */   }
/*     */   
/*     */   public final void set(FactionNPC a) {
/*  61 */     set((Faction)FACTIONS.player(), (Faction)a);
/*     */   }
/*     */   
/*     */   public LIST<? extends Faction> all(Faction f) {
/*  65 */     return this.list.all(f);
/*     */   }
/*     */   
/*     */   public boolean any(Faction f) {
/*  69 */     for (int fi = 0; fi < FACTIONS.active().size(); fi++) {
/*  70 */       Faction f2 = (Faction)FACTIONS.active().get(0);
/*  71 */       if (f != f2 && is(f, f2))
/*  72 */         return true; 
/*     */     } 
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public LIST<FactionNPC> player() {
/*  78 */     return this.list.player();
/*     */   }
/*     */   
/*     */   final class List {
/*  82 */     private int[] state = Alloc.ii(FACTIONS.MAX());
/*     */     private Faction cf;
/*  84 */     private final ArrayList<Faction> tmp = new ArrayList(FACTIONS.MAX());
/*  85 */     private final ArrayList<FactionNPC> player = new ArrayList(FACTIONS.MAX());
/*     */     
/*     */     public LIST<? extends Faction> all(Faction f) {
/*  88 */       if (f == FACTIONS.player()) {
/*  89 */         if (this.state[f.index()] != DIP.s.stateI) {
/*  90 */           this.state[f.index()] = DIP.s.stateI;
/*  91 */           this.player.clearSloppy();
/*  92 */           for (FactionNPC o : FACTIONS.NPCs()) {
/*  93 */             if (f != o && DipStance.this.is((Faction)o, f)) {
/*  94 */               this.player.add(o);
/*     */             }
/*     */           } 
/*     */         } 
/*  98 */         return (LIST)this.player;
/*     */       } 
/* 100 */       if (this.cf != f || this.state[f.index()] != DIP.s.stateI) {
/* 101 */         this.cf = f;
/* 102 */         this.state[f.index()] = DIP.s.stateI;
/* 103 */         this.tmp.clearSloppy();
/* 104 */         for (Faction o : FACTIONS.active()) {
/* 105 */           if (f != o && DipStance.this.is(o, f))
/* 106 */             this.tmp.add(o); 
/*     */         } 
/*     */       } 
/* 109 */       return (LIST<? extends Faction>)this.tmp;
/*     */     }
/*     */     
/*     */     public LIST<FactionNPC> player() {
/* 113 */       all((Faction)FACTIONS.player());
/* 114 */       return (LIST<FactionNPC>)this.player;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 121 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 126 */     return this.key;
/*     */   }
/*     */   
/* 129 */   private static CharSequence ¤¤minOpinion = "Minimum Opinion";
/*     */   static {
/* 131 */     D.ts(DipStance.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 136 */     GBox b = (GBox)box;
/* 137 */     box.title(this.name);
/* 138 */     box.text(this.desc);
/* 139 */     box.NL();
/*     */     
/* 141 */     if (this != DIP.WAR()) {
/* 142 */       b.textLL(¤¤minOpinion);
/* 143 */       b.tab(6);
/* 144 */       b.add((SPRITE)GFORMAT.f(b.text(), this.opinionNeeded));
/* 145 */       b.NL();
/*     */       
/* 147 */       b.textLL(Dic.¤¤Tariff);
/* 148 */       b.tab(6);
/* 149 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.tarif));
/* 150 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DipStance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */