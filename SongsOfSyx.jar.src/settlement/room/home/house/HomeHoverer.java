/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HGROUP;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ final class HomeHoverer
/*     */   extends UIRoomModule
/*     */ {
/*  23 */   private static CharSequence ¤¤Residents = "¤{0}  ({1})";
/*  24 */   private static CharSequence ¤¤VacantFor = "¤Vacant for {0}:";
/*  25 */   private static CharSequence ¤¤Any = "¤Any species of any class.";
/*  26 */   private static CharSequence ¤¤None = "¤None";
/*     */   static {
/*  28 */     D.ts(HomeHoverer.class);
/*     */   }
/*     */   
/*  31 */   private PO[] pos = new PO[40];
/*     */   
/*     */   public HomeHoverer() {
/*  34 */     GText t = new GText((UI.FONT()).S, 64);
/*  35 */     for (int i = 0; i < this.pos.length; i++) {
/*  36 */       this.pos[i] = new PO(t);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room in, int rx, int ry) {
/*  42 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(rx, ry);
/*     */     
/*  44 */     if (h == null) {
/*     */       return;
/*     */     }
/*  47 */     box.textL(Dic.¤¤Upgrade);
/*  48 */     box.tab(6);
/*  49 */     box.add((SPRITE)GFORMAT.iofkInv(box.text(), h.upgrade(), (SETT.ROOMS()).HOME.upgrades().max()));
/*  50 */     box.NL(8);
/*     */     
/*  52 */     if (h.occupants() > 0) {
/*  53 */       GText t = box.text();
/*  54 */       t.add(¤¤Residents);
/*  55 */       t.insert(0, (h.race()).info.namePosessive);
/*  56 */       t.insert(1, (h.occupant(0).indu().clas()).names);
/*  57 */       box.NL();
/*  58 */       box.textLL((CharSequence)t);
/*  59 */       box.add((SPRITE)GFORMAT.iofk(box.text(), h.occupants(), h.occupantsMax()));
/*  60 */       box.NL();
/*     */ 
/*     */       
/*  63 */       int ti = 0;
/*  64 */       for (int i = 0; i < h.occupants(); i++) {
/*  65 */         PO po = this.pos[i];
/*  66 */         po.h = h.occupant(i);
/*  67 */         box.add((SPRITE)po);
/*  68 */         if ((ti & 0x1) == 1)
/*  69 */           box.NL(); 
/*  70 */         ti++;
/*     */       } 
/*     */       
/*  73 */       box.NL(8);
/*     */       
/*  75 */       int ri = 0;
/*  76 */       ti = 0;
/*  77 */       for (RES_AMOUNT ra : h.race().home().clas(h.occupant(0).indu().clas()).resources()) {
/*  78 */         box.tab(ti * 2);
/*  79 */         box.add((SPRITE)ra.resource().icon());
/*  80 */         int curr = 0;
/*  81 */         int max = ra.amount() * h.occupants();
/*  82 */         for (int oi = 0; oi < h.occupants(); oi++) {
/*  83 */           curr += STATS.HOME().current(h.occupant(oi), ri);
/*     */         }
/*  85 */         ri++;
/*  86 */         box.add((SPRITE)GFORMAT.iofkInv(box.text(), curr, max));
/*  87 */         ti++;
/*  88 */         if (ti >= 4) {
/*  89 */           ti = 0;
/*  90 */           box.NL();
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  98 */       GText t = box.text();
/*  99 */       box.NL();
/* 100 */       t.add(¤¤VacantFor);
/* 101 */       t.insert(0, h.occupantsMax());
/* 102 */       box.add((SPRITE)t);
/* 103 */       box.NL();
/*     */       
/* 105 */       HGROUP.HTypeBits s = h.setting();
/*     */ 
/*     */       
/* 108 */       int a = 0;
/*     */       
/* 110 */       for (HGROUP tt : HGROUP.all()) {
/* 111 */         if (s.is(tt)) {
/* 112 */           a++;
/*     */         }
/*     */       } 
/* 115 */       int am = 0;
/* 116 */       if (a == HGROUP.all().size()) {
/* 117 */         box.text(¤¤Any);
/* 118 */       } else if (a == 0) {
/* 119 */         box.text(¤¤None);
/* 120 */       } else if (a <= HGROUP.all().size() / 2) {
/* 121 */         for (HGROUP tt : HGROUP.all()) {
/* 122 */           if (s.is(tt)) {
/* 123 */             box.add(tt.icon);
/* 124 */             am++;
/* 125 */             if (am > 10) {
/* 126 */               am = 0;
/* 127 */               box.NL();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 132 */         for (HGROUP tt : HGROUP.all()) {
/* 133 */           if (!s.is(tt)) {
/* 134 */             box.add(tt.icon);
/* 135 */             box.rewind(tt.icon.width());
/* 136 */             box.add((SPRITE)(UI.icons()).m.anti);
/* 137 */             am++;
/* 138 */             if (am > 10) {
/* 139 */               am = 0;
/* 140 */               box.NL();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     box.NL(8);
/* 153 */     box.textLL(Dic.¤¤Isolation);
/* 154 */     box.tab(5);
/* 155 */     box.add((SPRITE)GFORMAT.perc(box.text(), h.isolation()));
/*     */     
/* 157 */     super.hover(box, in, rx, ry);
/*     */   }
/*     */   
/*     */   private static class PO
/*     */     extends SPRITE.Imp
/*     */   {
/*     */     Humanoid h;
/*     */     private final GText t;
/*     */     
/*     */     PO(GText t) {
/* 167 */       super(320, 64);
/* 168 */       this.t = t;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 173 */       STATS.APPEARANCE().portraitRender(r, this.h.indu(), X1, Y1, 1);
/* 174 */       this.t.clear().add(STATS.APPEARANCE().name(this.h.indu()));
/* 175 */       this.t.setMaxChars(22);
/* 176 */       this.t.lablifySub();
/* 177 */       this.t.render(r, X1 + 40 + 4, Y1);
/* 178 */       this.t.clear().add(this.h.title());
/* 179 */       this.t.normalify();
/* 180 */       this.t.render(r, X1 + 40 + 4, Y1 + this.t.height() + 2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\HomeHoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */