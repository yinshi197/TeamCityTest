#!/bin/bash
git checkout -b feature/login
echo "Login feature" >> feature.txt
git add feature.txt
git commit -m "Add login feature"

git checkout main
git checkout -b bugfix/crash
echo "Fix crash on startup" >> bugfix.txt
git add bugfix.txt
git commit -m "Fix crash bug"

git checkout main
git tag v1.0
